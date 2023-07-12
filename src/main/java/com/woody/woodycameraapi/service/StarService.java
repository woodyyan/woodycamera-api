package com.woody.woodycameraapi.service;

import com.woody.woodycameraapi.entity.StarEntity;
import com.woody.woodycameraapi.model.StarRequest;
import com.woody.woodycameraapi.model.StarResponse;
import com.woody.woodycameraapi.model.StarsResponse;
import com.woody.woodycameraapi.repository.StarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StarService {
    private final StarRepository starRepository;

    public StarService(StarRepository starRepository) {
        this.starRepository = starRepository;
    }

    public StarResponse addStar(StarRequest starRequest) {
        Optional<StarEntity> starEntity = starRepository.findByUserIdAndImageId(starRequest.getUserId(), starRequest.getImageId());
        if (starEntity.isPresent()) {
            return new StarResponse(starRequest.getUserId(), starRequest.getImageId());
        } else {
            StarEntity newStar = new StarEntity();
            newStar.setUserId(starRequest.getUserId());
            newStar.setImageId(starRequest.getImageId());
            StarEntity saved = starRepository.save(newStar);
            return new StarResponse(saved.getUserId(), saved.getImageId());
        }
    }

    public StarsResponse searchStars(String userId) {
        List<StarEntity> stars = starRepository.findAllByUserId(userId);
        return new StarsResponse(userId, stars.stream().map(StarEntity::getImageId).toList());
    }
}
