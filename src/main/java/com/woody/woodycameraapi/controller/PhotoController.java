package com.woody.woodycameraapi.controller;

import com.woody.woodycameraapi.model.PhotoResponse;
import com.woody.woodycameraapi.service.PhotoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/photo")
public class PhotoController {
    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping
    public PhotoResponse getAllPhotos() {
        return photoService.getAllPhotos();
    }
}
