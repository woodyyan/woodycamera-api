package com.woody.woodycameraapi.controller;

import com.woody.woodycameraapi.model.LikeResponse;
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
    public LikeResponse addLike() {
        return likeService.addLike();
    }

    @GetMapping
    public LikeResponse getLike() {
        return likeService.getLike();
    }
}
