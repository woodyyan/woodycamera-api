package com.woody.woodycameraapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String email;
    private String familyName;
    private String givenName;
    private String userId;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
