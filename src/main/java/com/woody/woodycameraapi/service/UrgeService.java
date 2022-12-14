package com.woody.woodycameraapi.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.woody.woodycameraapi.entity.UrgeEntity;
import com.woody.woodycameraapi.model.UrgeResponse;
import com.woody.woodycameraapi.util.CosApi;
import org.springframework.stereotype.Service;

@Service
public class UrgeService {
    private static final String URGE_KEY = "database/urge.json";
    private final CosApi cosApi;

    public UrgeService(CosApi cosApi) {
        this.cosApi = cosApi;
    }

    public UrgeResponse urgeOnce() {
        String result = cosApi.download(URGE_KEY);
        UrgeEntity urge = JSONObject.parseObject(result, UrgeEntity.class);
        urge.addOne();
        cosApi.upload(JSON.toJSONString(urge), URGE_KEY);
        return UrgeResponse.builder().count(urge.getCount()).build();
    }
}
