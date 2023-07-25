package com.woody.woodycameraapi.service;

import com.woody.woodycameraapi.entity.LikeEntity;
import com.woody.woodycameraapi.model.*;
import com.woody.woodycameraapi.repository.LikeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LikeService {
    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public LikesResponse searchLikes(LikesRequest likesRequest) {
        List<LikeEntity> likeEntities = likeRepository.findAllByImageIdIn(likesRequest.getImageIds());
        List<LikeItem> items = likesRequest.getImageIds().stream().map(it -> new LikeItem(it, likeEntities.stream().filter(entity -> entity.getImageId().equals(it)).count())).toList();
        return LikesResponse.builder().imageItems(items).build();
    }

    public LikeResponse toggleLike(LikeRequest likeRequest) {
        Optional<LikeEntity> likeEntity = likeRepository.findByUserIdAndImageId(likeRequest.getUserId(), likeRequest.getImageId());
        if (likeEntity.isPresent()) {
            likeRepository.delete(likeEntity.get());
            return new LikeResponse();
        } else {
            LikeEntity newLike = new LikeEntity();
            newLike.setUserId(likeRequest.getUserId());
            newLike.setImageId(likeRequest.getImageId());
            newLike.setCreatedTime(LocalDateTime.now());
            LikeEntity saved = likeRepository.save(newLike);
            return new LikeResponse(saved.getUserId(), saved.getImageId());
        }
    }
}
