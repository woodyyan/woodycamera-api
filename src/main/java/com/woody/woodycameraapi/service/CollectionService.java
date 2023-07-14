package com.woody.woodycameraapi.service;

import com.woody.woodycameraapi.entity.PhotoEntity;
import com.woody.woodycameraapi.model.CollectionResponse;
import com.woody.woodycameraapi.model.CollectionsResponse;
import com.woody.woodycameraapi.model.PhotoItem;
import com.woody.woodycameraapi.repository.PhotoRepository;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;

@Service
public class CollectionService {
    private static final String LINE_DELIMITER = "\\|";
    private final PhotoRepository photoRepository;

    public CollectionService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public CollectionsResponse getAllCollections() {
        List<PhotoEntity> allPhotos = photoRepository.findAll();
        CollectionsResponse response = new CollectionsResponse();
        List<CollectionResponse> collections = new ArrayList<>();
        Map<Integer, List<PhotoEntity>> groupedPhotos = allPhotos.stream().collect(groupingBy(PhotoEntity::getCollectionId));
        for (Map.Entry<Integer, List<PhotoEntity>> entry : groupedPhotos.entrySet()) {
            CollectionResponse collectionResponse = new CollectionResponse();
            List<PhotoEntity> photos = entry.getValue();
            PhotoEntity first = photos.get(0);
            collectionResponse.setModelName(first.getModelName());
            collectionResponse.setCity(first.getCity());
            collectionResponse.setDate(first.getDate());
            collectionResponse.setTags(extractTags(photos));
            collectionResponse.setUrls(photos.stream().map(it -> new PhotoItem(it.getId(), it.getUrl())).toList());
            collections.add(collectionResponse);
        }
        response.setCollections(collections);
        return response;
    }

    private List<String> extractTags(List<PhotoEntity> photos) {
        Set<String> tags = new HashSet<>();
        for (PhotoEntity photo : photos) {
            tags.addAll(Arrays.stream(photo.getTags().split(LINE_DELIMITER)).toList());
        }
        return tags.stream().toList();
    }
}
