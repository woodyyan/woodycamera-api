package com.woody.woodycameraapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoResponse {
    private String modelName;
    private int collectionId;
    private String url;
    private String tags;
    private Date date;
    private String city;
}
