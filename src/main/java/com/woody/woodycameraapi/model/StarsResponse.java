package com.woody.woodycameraapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StarsResponse {
    private String userId;
    private List<String> imageId = new ArrayList<>();
}
