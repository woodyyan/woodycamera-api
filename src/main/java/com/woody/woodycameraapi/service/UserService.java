package com.woody.woodycameraapi.service;

import com.woody.woodycameraapi.entity.UserEntity;
import com.woody.woodycameraapi.exception.Error;
import com.woody.woodycameraapi.exception.ErrorException;
import com.woody.woodycameraapi.model.UserRequest;
import com.woody.woodycameraapi.model.UserResponse;
import com.woody.woodycameraapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(UserRequest userRequest) {
        Optional<UserEntity> userEntity = userRepository.findByUserId(userRequest.getUserId());
        if (userEntity.isPresent()) {
            UserEntity existing = userEntity.get();
            existing.setUserId(userRequest.getUserId());
            existing.setEmail(userRequest.getEmail());
            existing.setFamilyName(userRequest.getFamilyName());
            existing.setGivenName(userRequest.getGivenName());
            userRepository.save(existing);
            return new UserResponse(userRequest.getEmail(), userRequest.getFamilyName(), userRequest.getGivenName(), userRequest.getUserId());
        } else {
            UserEntity newUser = new UserEntity();
            newUser.setUserId(userRequest.getUserId());
            newUser.setEmail(userRequest.getEmail());
            newUser.setFamilyName(userRequest.getFamilyName());
            newUser.setGivenName(userRequest.getGivenName());
            UserEntity savedUser = userRepository.save(newUser);
            return new UserResponse(savedUser.getEmail(), savedUser.getFamilyName(), savedUser.getGivenName(), savedUser.getUserId());
        }
    }

    public UserResponse getUser(String userId) {
        Optional<UserEntity> entity = userRepository.findByUserId(userId);
        if (entity.isPresent()) {
            UserEntity user = entity.get();
            return new UserResponse(user.getEmail(), user.getFamilyName(), user.getGivenName(), user.getUserId());
        }
        throw new ErrorException(HttpStatus.NOT_FOUND, new Error("Not Found", "User Id Not Found"));
    }
}
