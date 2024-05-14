package com.example.minh.controller;

import com.example.minh.model.request.ImageRequest;
import com.example.minh.model.response.ImageResponse;
import com.example.minh.service.impl.CloudinaryService;
import com.example.minh.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    ImageService imageService;

    @Autowired
    CloudinaryService cloudinaryService;

    @PostMapping("/add")
    public ResponseEntity<?> uploadImage(@ModelAttribute ImageRequest imageRequest) throws IOException {

        return ResponseEntity.status(HttpStatus.OK).body(imageService.uploadImage(imageRequest));
    }

    @GetMapping("detail/{filename}")
    public ResponseEntity<ImageResponse> downloadImage(@PathVariable String filename) {
        return ResponseEntity.status(HttpStatus.OK).body(imageService.getImageByName(filename));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(imageService.deleteImage(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateImage(@PathVariable Long id, @ModelAttribute ImageRequest imageRequest) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(imageService.updateImage(imageRequest, id));
    }
}
