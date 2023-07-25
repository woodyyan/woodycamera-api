package com.woody.woodycameraapi.repository;

import com.woody.woodycameraapi.entity.CameraUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<CameraUserEntity, Long> {
    Optional<CameraUserEntity> findByUserId(String userId);

    int countByCreatedTimeBefore(LocalDateTime createdTime);
}
