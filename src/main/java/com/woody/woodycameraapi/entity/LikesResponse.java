package com.woody.woodycameraapi.entity;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class LikesResponse {
    private List<LikeItem> imageItems = new ArrayList<>();
}
