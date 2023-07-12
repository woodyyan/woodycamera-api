package com.woody.woodycameraapi.controller;

import com.woody.woodycameraapi.entity.LikesResponse;
import com.woody.woodycameraapi.model.LikeRequest;
import com.woody.woodycameraapi.model.LikeResponse;
import com.woody.woodycameraapi.model.LikesRequest;
import com.woody.woodycameraapi.service.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
