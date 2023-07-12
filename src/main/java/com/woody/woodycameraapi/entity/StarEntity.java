package com.woody.woodycameraapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "star")
public class StarEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String userId;
    private String imageId;
}
