package com.woody.woodycameraapi.repository;

import com.woody.woodycameraapi.entity.UrgeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrgeRepository extends JpaRepository<UrgeEntity, Long> {
    Optional<UrgeEntity> findByUrgedPhotographer(String urgedPhotographer);
}
