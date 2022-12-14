package com.woody.woodycameraapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeItem {
    private String imageId;
    private int count;

    public void addOne() {
        count += 1;
    }
}
