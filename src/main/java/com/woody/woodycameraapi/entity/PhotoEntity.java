package com.woody.woodycameraapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "photo")
public class PhotoEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String modelName;
    private int collectionId;
    private String url;
    private String tags;
    private Date date;
    private String city;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
