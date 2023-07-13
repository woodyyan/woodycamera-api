package com.woody.woodycameraapi.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LikesResponse {
    private List<LikeItem> imageItems;
}
