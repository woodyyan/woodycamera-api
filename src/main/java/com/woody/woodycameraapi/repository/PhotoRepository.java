package com.woody.woodycameraapi.repository;

import com.woody.woodycameraapi.entity.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {
}
