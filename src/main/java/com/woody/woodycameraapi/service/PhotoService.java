package com.woody.woodycameraapi.service;

import com.alibaba.fastjson2.JSONObject;
import com.woody.woodycameraapi.model.PhotoResponse;
import com.woody.woodycameraapi.util.CosApi;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {
    private static final String PHOTO_KEY = "database/woodycamera.json";
    private final CosApi cosApi;

    public PhotoService(CosApi cosApi) {
        this.cosApi = cosApi;
    }

    public PhotoResponse getAllPhotos() {
        String result = cosApi.download(PHOTO_KEY);
        return JSONObject.parseObject(result, PhotoResponse.class);
    }
}
