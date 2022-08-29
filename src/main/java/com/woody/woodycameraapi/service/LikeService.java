package com.woody.woodycameraapi.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.woody.woodycameraapi.entity.LikeEntity;
import com.woody.woodycameraapi.entity.LikeItem;
import com.woody.woodycameraapi.model.LikeResponse;
import com.woody.woodycameraapi.model.UrgeResponse;
import com.woody.woodycameraapi.util.CosApi;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {
    private static final String LIKE_KEY = "database/like.json";
    private final CosApi cosApi;

    public LikeService(CosApi cosApi) {
        this.cosApi = cosApi;
    }

    public LikeResponse addLike(String imageId) {
        String result = cosApi.download(LIKE_KEY);
        LikeEntity like = JSONObject.parseObject(result, LikeEntity.class);
        Optional<LikeItem> item = like.getLikeItems().stream().filter(it -> it.getImageId().equals(imageId)).findFirst();
        int count = 0;
        if (item.isPresent()) {
            item.get().addOne();
            count = item.get().getCount();
        } else {
            LikeItem newItem = new LikeItem();
            newItem.setCount(1);
            newItem.setImageId(imageId);
            like.getLikeItems().add(newItem);
            count = newItem.getCount();
        }
        cosApi.upload(JSON.toJSONString(like), LIKE_KEY);
        return LikeResponse.builder().count(count).imageId(imageId).build();
    }

    public LikeResponse getLike() {
        return null;
    }
}
