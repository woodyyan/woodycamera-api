package com.woody.woodycameraapi.entity;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserEntity {
    private List<UserInfo> users = new ArrayList<>();
}
