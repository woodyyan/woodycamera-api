package com.woody.woodycameraapi.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ModelResponse {
    private int index;
    private List<String> urls = new ArrayList<>();
    private String modelName;
    private String city;
    private List<String> tags = new ArrayList<>();
    private String date;
}
