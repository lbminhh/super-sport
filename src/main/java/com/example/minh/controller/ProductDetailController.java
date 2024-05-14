package com.example.minh.controller;

import com.example.minh.entity.Size;
import com.example.minh.model.request.ProductDetailRequest;
import com.example.minh.model.request.SizeRequest;
import com.example.minh.model.response.ApiResponse;
import com.example.minh.model.response.ProductDetailResponse;
import com.example.minh.service.ProductDetailService;
import com.example.minh.service.SizeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/product-detail")
public class ProductDetailController {

    @Autowired
    ProductDetailService productDetailService;

    @PostMapping("/add")
    public ApiResponse<ProductDetailResponse> addProductDetail(@RequestBody @Valid ProductDetailRequest productDetailRequest) {
        ApiResponse<ProductDetailResponse> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setResult(productDetailService.addProductDetail(productDetailRequest));
        apiResponse.setMessage("add product-detail succesfully!");
        return apiResponse;
    }

    @PutMapping("/update/{id}")
    public ApiResponse<ProductDetailResponse> updateSize(@RequestBody @Valid ProductDetailRequest productDetailRequest, @PathVariable UUID id) {
        ApiResponse<ProductDetailResponse> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setResult(productDetailService.updateProductDetail(productDetailRequest, id));
        apiResponse.setMessage("update product-detail succesfully!");
        return apiResponse;
    }

    @GetMapping("/list")
    public ApiResponse<List<ProductDetailResponse>> getAllSizes() {
        ApiResponse<List<ProductDetailResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setResult(productDetailService.getAllProducts());
        apiResponse.setMessage("get all product-detail successfully!");
        return apiResponse;
    }

}
