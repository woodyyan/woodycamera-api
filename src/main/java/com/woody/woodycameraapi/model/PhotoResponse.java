package com.woody.woodycameraapi.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PhotoResponse {
    private List<ModelResponse> models = new ArrayList<>();
}
