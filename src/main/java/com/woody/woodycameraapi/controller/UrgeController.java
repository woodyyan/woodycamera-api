package com.woody.woodycameraapi.controller;

import com.woody.woodycameraapi.model.UrgeResponse;
import com.woody.woodycameraapi.service.UrgeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/urge")
public class UrgeController {
    private final UrgeService urgeService;

    public UrgeController(UrgeService urgeService) {
        this.urgeService = urgeService;
    }

    @PostMapping
    public UrgeResponse urgeOnce() {
        return urgeService.urgeOnce();
    }
}
