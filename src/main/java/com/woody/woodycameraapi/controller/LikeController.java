package com.woody.woodycameraapi.controller;

import com.woody.woodycameraapi.model.LikeResponse;
import com.woody.woodycameraapi.service.LikeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public LikeResponse addLike(@RequestParam String imageId) {
        return likeService.addLike(imageId);
    }

    @GetMapping
    public LikeResponse getLike() {
        return likeService.getLike();
    }
}
