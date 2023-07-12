package com.woody.woodycameraapi.repository;

import com.woody.woodycameraapi.entity.StarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StarRepository extends JpaRepository<StarEntity, Long> {
    Optional<StarEntity> findByUserIdAndImageId(String userId, String imageId);

    List<StarEntity> findAllByUserId(String userId);
}
