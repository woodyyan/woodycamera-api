package com.woody.woodycameraapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeEntity {
    private List<LikeItem> likeItems = new ArrayList<>();
}
