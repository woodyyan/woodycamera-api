package com.woody.woodycameraapi.controller;

import com.woody.woodycameraapi.model.UserRequest;
import com.woody.woodycameraapi.model.UserResponse;
import com.woody.woodycameraapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }
}
