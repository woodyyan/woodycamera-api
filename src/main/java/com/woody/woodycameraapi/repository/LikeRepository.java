package com.woody.woodycameraapi.repository;

import com.woody.woodycameraapi.entity.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, Long> {
    Optional<LikeEntity> findByUserIdAndImageId(String userId, String imageId);

    List<LikeEntity> findAllByImageIdIn(List<String> images);
}
