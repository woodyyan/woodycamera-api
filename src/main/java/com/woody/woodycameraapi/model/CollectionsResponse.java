package com.woody.woodycameraapi.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CollectionsResponse {
    private List<CollectionResponse> collections = new ArrayList<>();
}
