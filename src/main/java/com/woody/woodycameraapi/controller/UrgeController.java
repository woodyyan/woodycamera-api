package com.woody.woodycameraapi.controller;

import com.woody.woodycameraapi.model.UrgeResponse;
import com.woody.woodycameraapi.service.UrgeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/urge")
public class UrgeController {
    private final UrgeService urgeService;

    public UrgeController(UrgeService urgeService) {
        this.urgeService = urgeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UrgeResponse urgeOnce() {
        return urgeService.urgeOnce();
    }

    @GetMapping
    public UrgeResponse getUrgeCount() {
        return urgeService.getUrgeCount();
    }

    @PostMapping("/clear")
    public UrgeResponse clearUrge() {
        return urgeService.clearUrge();
    }
}
