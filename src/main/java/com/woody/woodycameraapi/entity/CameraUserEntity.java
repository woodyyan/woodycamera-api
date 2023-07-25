package com.woody.woodycameraapi.entity;


import lombok.Data;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "camera_user")
public class CameraUserEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String email;
    private String familyName;
    private String givenName;
    private String userId;
    private DateTime createdTime;
    private DateTime updatedTime;
}
