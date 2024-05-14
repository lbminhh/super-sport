package com.example.minh.service;

import com.example.minh.model.request.ImageRequest;
import com.example.minh.model.response.ImageResponse;

import java.io.IOException;

public interface ImageService {

    String uploadImage(ImageRequest imageRequest) throws IOException;

    ImageResponse getImageByName(String fileName);

    String deleteImage(Long id);

    String updateImage(ImageRequest imageRequest, Long id) throws IOException;

}
