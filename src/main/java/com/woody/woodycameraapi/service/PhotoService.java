package com.woody.woodycameraapi.service;

import com.woody.woodycameraapi.entity.ImageEntity;
import com.woody.woodycameraapi.entity.ModelEntity;
import com.woody.woodycameraapi.model.ModelResponse;
import com.woody.woodycameraapi.model.PhotoResponse;
import com.woody.woodycameraapi.repository.ImageRepository;
import com.woody.woodycameraapi.repository.ModelRepository;
import com.woody.woodycameraapi.util.CosApi;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhotoService {
    private static final String PHOTO_KEY = "database/woodycamera.json";
    private final CosApi cosApi;
    private final ModelRepository modelRepository;
    private final ImageRepository imageRepository;

    public PhotoService(CosApi cosApi, ModelRepository modelRepository, ImageRepository imageRepository) {
        this.cosApi = cosApi;
        this.modelRepository = modelRepository;
        this.imageRepository = imageRepository;
    }

    public PhotoResponse getAllPhotos() {
//         从COS读取
//        String result = cosApi.download(PHOTO_KEY);
//        return JSONObject.parseObject(result, PhotoResponse.class);

        List<ModelEntity> modelEntities = modelRepository.findAll();
        PhotoResponse response = new PhotoResponse();
        List<ModelResponse> models = new ArrayList<>();
        for (ModelEntity model : modelEntities) {
            ModelResponse modelResponse = new ModelResponse();
            modelResponse.setModelName(model.getModelName());
            modelResponse.setCity(model.getCity());
            modelResponse.setDate(model.getDate());
            modelResponse.setIndex(model.getIndex());
            modelResponse.setTags(Arrays.stream(model.getTags().split("\\|")).toList());
            List<ImageEntity> imageEntities = imageRepository.findAllByModelId(model.getId());
            modelResponse.setUrls(imageEntities.stream().map(ImageEntity::getUrl).collect(Collectors.toList()));
            models.add(modelResponse);
        }
        response.setModels(models);
        return response;
    }
}
