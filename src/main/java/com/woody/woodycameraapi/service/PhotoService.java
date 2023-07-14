package com.woody.woodycameraapi.service;

import com.woody.woodycameraapi.entity.PhotoEntity;
import com.woody.woodycameraapi.model.PhotoRequest;
import com.woody.woodycameraapi.model.PhotoResponse;
import com.woody.woodycameraapi.repository.PhotoRepository;
import org.springframework.stereotype.Service;

@Service
public class PhotoService {
    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public PhotoResponse createPhoto(PhotoRequest photoRequest) {
        PhotoEntity photo = new PhotoEntity();
        photo.setTags(photoRequest.getTags());
        photo.setUrl(photoRequest.getUrl());
        photo.setDate(photoRequest.getDate());
        photo.setCity(photoRequest.getCity());
        photo.setModelName(photoRequest.getModelName());
        photo.setCollectionId(photoRequest.getCollectionId());
        PhotoEntity saved = photoRepository.save(photo);
        return new PhotoResponse(saved.getModelName(), saved.getCollectionId(), saved.getUrl(), saved.getTags(), saved.getDate(), saved.getCity());
    }
}
