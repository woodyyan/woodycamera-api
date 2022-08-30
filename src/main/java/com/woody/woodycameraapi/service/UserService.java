package com.woody.woodycameraapi.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.woody.woodycameraapi.entity.UserEntity;
import com.woody.woodycameraapi.entity.UserInfo;
import com.woody.woodycameraapi.exception.Error;
import com.woody.woodycameraapi.exception.ErrorException;
import com.woody.woodycameraapi.model.UserRequest;
import com.woody.woodycameraapi.model.UserResponse;
import com.woody.woodycameraapi.util.CosApi;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static final String USER_KEY = "database/user.json";
    private final CosApi cosApi;

    public UserService(CosApi cosApi) {
        this.cosApi = cosApi;
    }

    public UserResponse createUser(UserRequest userRequest) {
        String result = cosApi.download(USER_KEY);
        UserEntity userEntity = JSONObject.parseObject(result, UserEntity.class);
        Optional<UserInfo> first = userEntity.getUsers().stream().filter(it -> it.getUserId().equals(userRequest.getUserId())).findFirst();
        if (first.isPresent()) {
            UserInfo userInfo = first.get();
            userInfo.setFamilyName(userRequest.getFamilyName());
            userInfo.setGivenName(userRequest.getGivenName());
            userInfo.setEmail(userRequest.getEmail());
        } else {
            UserInfo userInfo = new UserInfo(userRequest.getEmail(), userRequest.getFamilyName(), userRequest.getGivenName(), userRequest.getUserId());
            userEntity.getUsers().add(userInfo);
        }
        cosApi.upload(JSON.toJSONString(userEntity), USER_KEY);
        return new UserResponse(userRequest.getEmail(), userRequest.getFamilyName(), userRequest.getGivenName(), userRequest.getUserId());
    }

    public UserResponse getUser(String userId) {
        String result = cosApi.download(USER_KEY);
        UserEntity userEntity = JSONObject.parseObject(result, UserEntity.class);
        Optional<UserInfo> first = userEntity.getUsers().stream().filter(it -> it.getUserId().equals(userId)).findFirst();
        if (first.isPresent()) {
            UserInfo userInfo = first.get();
            return new UserResponse(userInfo.getEmail(), userInfo.getFamilyName(), userInfo.getGivenName(), userInfo.getUserId());
        }
        throw new ErrorException(HttpStatus.NOT_FOUND, new Error("Not Found", "User Id Not Found"));
    }
}
