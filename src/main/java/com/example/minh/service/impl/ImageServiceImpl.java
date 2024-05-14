package com.example.minh.service.impl;

import com.example.minh.entity.Color;
import com.example.minh.entity.Image;
import com.example.minh.entity.Product;
import com.example.minh.exception.AppException;
import com.example.minh.model.enums.ErrorCode;
import com.example.minh.model.request.ImageRequest;
import com.example.minh.model.response.ImageResponse;
import com.example.minh.repository.ColorRepository;
import com.example.minh.repository.ImageRepository;
import com.example.minh.repository.ProductRepository;
import com.example.minh.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Override
    public String uploadImage(ImageRequest imageRequest) throws IOException {

        Color color = colorRepository.findById(imageRequest.getColorID())
                .orElseThrow(() -> new AppException(ErrorCode.COLOR_NOT_EXIST));

        Product product = productRepository.findById(imageRequest.getProductID())
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXIST));

        BufferedImage bufferedImage = ImageIO.read(imageRequest.getFile().getInputStream());
        if (bufferedImage == null) {
            throw new AppException(ErrorCode.IMAGE_IS_NOT_AVAILABLE);
        }

        Map result = cloudinaryService.upload(imageRequest.getFile());

        Image image = imageRepository.save(Image.builder()
                .name(imageRequest.getFile().getOriginalFilename())
                .typeName(imageRequest.getFile().getContentType())
                .product(product)
                .color(color)
                .size(imageRequest.getFile().getSize())
                .imageId(String.valueOf(result.get("public_id")))
                .imageUrl(String.valueOf(result.get("url")))
                .build());

        if (image != null) {
            return "Saved Image in DB  with name " + imageRequest.getFile().getOriginalFilename();
        }
        return "Image not save...";
    }

    @Override
    public ImageResponse getImageByName(String fileName) {
        Image image = imageRepository.findByName(fileName)
                .orElseThrow(() -> new AppException(ErrorCode.IMAGE_IS_NOT_EXIST));
        ImageResponse imageResponse = ImageResponse.builder()
                .name(image.getName())
                .url(image.getImageUrl())
                .build();
        return imageResponse;
    }

    @Override
    public String deleteImage(Long id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.IMAGE_IS_NOT_EXIST));
        try {
            cloudinaryService.delete(image.getImageId());
        } catch (IOException e) {
            throw new AppException(ErrorCode.FAIL_UPLOAD_TO_CLOUDINARY);
        } finally {
            imageRepository.delete(image);
        }
        return "delete " + image.getName() + " successfully!";
    }

    @Override
    public String updateImage(ImageRequest imageRequest, Long id) throws IOException {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.IMAGE_IS_NOT_EXIST));

        Color color = colorRepository.findById(imageRequest.getColorID())
                .orElseThrow(() -> new AppException(ErrorCode.COLOR_NOT_EXIST));

        Product product = productRepository.findById(imageRequest.getProductID())
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXIST));

        System.out.println(imageRequest);

        try {
            cloudinaryService.delete(image.getImageId());
        } catch (IOException e) {
            throw new AppException(ErrorCode.FAIL_UPLOAD_TO_CLOUDINARY);
        } finally {
            Map result = cloudinaryService.upload(imageRequest.getFile());
            Image imageSave = imageRepository.save(Image.builder()
                    .id(image.getId())
                    .name(imageRequest.getFile().getOriginalFilename())
                    .typeName(imageRequest.getFile().getContentType())
                    .product(product)
                    .color(color)
                    .size(imageRequest.getFile().getSize())
                    .imageId(String.valueOf(result.get("public_id")))
                    .imageUrl(String.valueOf(result.get("url")))
                    .build());
            imageRepository.save(imageSave);
        }
        return "Saved Image in DB  with name " + imageRequest.getFile().getOriginalFilename();
    }
}
