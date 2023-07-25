package com.woody.woodycameraapi.controller;

import com.woody.woodycameraapi.model.StarRequest;
import com.woody.woodycameraapi.model.StarResponse;
import com.woody.woodycameraapi.model.StarsResponse;
import com.woody.woodycameraapi.service.StarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/star")
public class StarController {
    private final StarService starService;

    public StarController(StarService starService) {
        this.starService = starService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StarResponse addStar(@RequestBody StarRequest starRequest) {
        return starService.addStar(starRequest);
    }

    @GetMapping("/{userId}")
    public StarsResponse searchStars(@PathVariable String userId) {
        return starService.searchStars(userId);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeStar(@RequestParam String userId, @RequestParam String imageId) {
        starService.removeStar(userId, imageId);
    }
}
