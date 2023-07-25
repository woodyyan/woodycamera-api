package com.woody.woodycameraapi.service;

import com.woody.woodycameraapi.entity.CameraUserEntity;
import com.woody.woodycameraapi.exception.Error;
import com.woody.woodycameraapi.exception.ErrorException;
import com.woody.woodycameraapi.model.UserRequest;
import com.woody.woodycameraapi.model.UserResponse;
import com.woody.woodycameraapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(UserRequest userRequest) {
        Optional<CameraUserEntity> userEntity = userRepository.findByUserId(userRequest.getUserId());
        if (userEntity.isPresent()) {
            CameraUserEntity existing = userEntity.get();
            existing.setUpdatedDate(new Date(System.currentTimeMillis()));
            userRepository.save(existing);
            return new UserResponse(userRequest.getEmail(), userRequest.getFamilyName(), userRequest.getGivenName(), userRequest.getUserId());
        } else {
            CameraUserEntity newUser = new CameraUserEntity();
            newUser.setUserId(userRequest.getUserId());
            newUser.setEmail(userRequest.getEmail());
            newUser.setFamilyName(userRequest.getFamilyName());
            newUser.setGivenName(userRequest.getGivenName());
            newUser.setUpdatedDate(new Date(System.currentTimeMillis()));
            newUser.setCreatedDate(new Date(System.currentTimeMillis()));
            CameraUserEntity savedUser = userRepository.save(newUser);
            return new UserResponse(savedUser.getEmail(), savedUser.getFamilyName(), savedUser.getGivenName(), savedUser.getUserId());
        }
    }

    public UserResponse getUser(String userId) {
        Optional<CameraUserEntity> entity = userRepository.findByUserId(userId);
        if (entity.isPresent()) {
            CameraUserEntity user = entity.get();
            return new UserResponse(user.getEmail(), user.getFamilyName(), user.getGivenName(), user.getUserId());
        }
        throw new ErrorException(HttpStatus.NOT_FOUND, new Error("Not Found", "User Id Not Found"));
    }
}
