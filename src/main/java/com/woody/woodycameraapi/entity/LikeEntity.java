package com.woody.woodycameraapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "like_image")
public class LikeEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String userId;
    private String imageId;
    private LocalDateTime createdTime;
}
