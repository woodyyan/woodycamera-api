package com.woody.woodycameraapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrgeEntity {
    private int count;

    public void addOne() {
        count += 1;
    }
}
