package com.woody.woodycameraapi.controller;

import com.woody.woodycameraapi.model.CollectionsResponse;
import com.woody.woodycameraapi.service.CollectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/collection")
public class CollectionController {
    private final CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @GetMapping
    public CollectionsResponse getAllCollections() {
        return collectionService.getAllCollections();
    }
}
