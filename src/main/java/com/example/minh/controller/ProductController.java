package com.example.minh.controller;

import com.example.minh.model.request.ProductRequest;
import com.example.minh.model.response.ApiResponse;
import com.example.minh.model.response.ProductResponse;
import com.example.minh.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ApiResponse<ProductResponse> addProduct(@RequestBody @Valid ProductRequest productRequest) {
        ApiResponse<ProductResponse> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1001);
        apiResponse.setResult(productService.addProduct(productRequest));
        apiResponse.setMessage("add product successfully!");
        return apiResponse;
    }

    @PutMapping("/update/{id}")
    public ApiResponse<ProductResponse> updateProduct(@RequestBody @Valid ProductRequest productRequest, @PathVariable UUID id) {
        ApiResponse<ProductResponse> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1001);
        apiResponse.setResult(productService.update(productRequest, id));
        apiResponse.setMessage("update product successfully!");
        return apiResponse;
    }

    @GetMapping("/list")
    public ApiResponse<List<ProductResponse>> getAllProducts() {
        ApiResponse<List<ProductResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1001);
        apiResponse.setResult(productService.getAllProducts());
        apiResponse.setMessage("get all product successfully!");
        return apiResponse;
    }
}
