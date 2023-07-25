package com.woody.woodycameraapi.service;

import com.woody.woodycameraapi.entity.UrgeEntity;
import com.woody.woodycameraapi.exception.Error;
import com.woody.woodycameraapi.exception.ErrorException;
import com.woody.woodycameraapi.model.UrgeResponse;
import com.woody.woodycameraapi.repository.UrgeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UrgeService {
    private static final String URGED_PHOTOGRAPHER = "Woody";
    private final UrgeRepository urgeRepository;

    public UrgeService(UrgeRepository urgeRepository) {
        this.urgeRepository = urgeRepository;
    }

    public UrgeResponse urgeOnce() {
        Optional<UrgeEntity> urgeEntity = urgeRepository.findByUrgedPhotographer(URGED_PHOTOGRAPHER);
        if (urgeEntity.isPresent()) {
            UrgeEntity urge = urgeEntity.get();
            urge.setCount(urge.getCount() + 1);
            urge.setUpdatedTime(LocalDateTime.now());
            UrgeEntity saved = urgeRepository.save(urge);
            return new UrgeResponse(saved.getCount());
        } else {
            UrgeEntity urge = new UrgeEntity();
            urge.setCount(1);
            urge.setUpdatedTime(LocalDateTime.now());
            urge.setCreatedTime(LocalDateTime.now());
            urge.setUrgedPhotographer(URGED_PHOTOGRAPHER);
            UrgeEntity saved = urgeRepository.save(urge);
            return new UrgeResponse(saved.getCount());
        }
    }

    public UrgeResponse clearUrge() {
        Optional<UrgeEntity> urgeEntity = urgeRepository.findByUrgedPhotographer(URGED_PHOTOGRAPHER);
        if (urgeEntity.isPresent()) {
            UrgeEntity urge = urgeEntity.get();
            urge.setCount(0);
            urge.setUpdatedTime(LocalDateTime.now());
            UrgeEntity saved = urgeRepository.save(urge);
            return new UrgeResponse(saved.getCount());
        }
        throw new ErrorException(HttpStatus.NOT_FOUND, new Error("Not Found", "Urged Photographer Not Found"));
    }

    public UrgeResponse getUrgeCount() {
        Optional<UrgeEntity> urgeEntity = urgeRepository.findByUrgedPhotographer(URGED_PHOTOGRAPHER);
        if (urgeEntity.isPresent()) {
            UrgeEntity urge = urgeEntity.get();
            return new UrgeResponse(urge.getCount());
        }
        return new UrgeResponse(0);
    }
}
