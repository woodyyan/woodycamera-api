package com.woody.woodycameraapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "urge_photographer")
public class UrgeEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String urgedPhotographer;
    private int count;
}
