package com.woody.woodycameraapi.controller;

import com.woody.woodycameraapi.model.LikesResponse;
import com.woody.woodycameraapi.model.LikeRequest;
import com.woody.woodycameraapi.model.LikeResponse;
import com.woody.woodycameraapi.model.LikesRequest;
import com.woody.woodycameraapi.service.LikeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/like")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public LikeResponse addLike(LikeRequest likeRequest) {
        return likeService.toggleLike(likeRequest);
    }

    @GetMapping
    public LikesResponse searchLikes(LikesRequest likesRequest) {
        return likeService.searchLikes(likesRequest);
    }
}
