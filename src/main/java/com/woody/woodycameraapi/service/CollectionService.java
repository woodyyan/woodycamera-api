package com.woody.woodycameraapi.service;

import com.woody.woodycameraapi.entity.ImageEntity;
import com.woody.woodycameraapi.model.CollectionResponse;
import com.woody.woodycameraapi.model.CollectionsResponse;
import com.woody.woodycameraapi.repository.ImageRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

@Service
public class CollectionService {
    private final ImageRepository imageRepository;

    public CollectionService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public CollectionsResponse getAllCollections() {
        List<ImageEntity> allImages = imageRepository.findAll();
        CollectionsResponse response = new CollectionsResponse();
        List<CollectionResponse> collections = new ArrayList<>();
        Map<Integer, List<ImageEntity>> groupedImages = allImages.stream().collect(groupingBy(ImageEntity::getCollectionId));
        for (Map.Entry<Integer, List<ImageEntity>> entry : groupedImages.entrySet()) {
            CollectionResponse collectionResponse = new CollectionResponse();
            List<ImageEntity> images = entry.getValue();
            ImageEntity first = images.get(0);
            collectionResponse.setModelName(first.getModelName());
            collectionResponse.setCity(first.getCity());
            collectionResponse.setDate(first.getDate());
            collectionResponse.setTags(images.stream().map(ImageEntity::getTag).toList());
            collectionResponse.setUrls(images.stream().map(ImageEntity::getUrl).toList());
            collections.add(collectionResponse);
        }
        response.setCollections(collections);
        return response;
    }
}
