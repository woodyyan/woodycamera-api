package com.woody.woodycameraapi.model;

import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class CollectionResponse {
    private List<PhotoItem> urls = new ArrayList<>();
    private String modelName;
    private String city;
    private List<String> tags = new ArrayList<>();
    private Date date;
}
