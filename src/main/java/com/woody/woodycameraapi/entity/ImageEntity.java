package com.woody.woodycameraapi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "image")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String modelName;
    private int collectionId;
    private String url;
    private String tag;
    private Date date;
    private String city;
}
