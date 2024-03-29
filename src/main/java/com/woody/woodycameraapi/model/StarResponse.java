package com.woody.woodycameraapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarResponse {
    private String userId;
    private String imageId;
}
