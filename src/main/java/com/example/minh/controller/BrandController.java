package com.example.minh.controller;

import com.example.minh.entity.Brand;
import com.example.minh.entity.Size;
import com.example.minh.model.request.BrandRequest;
import com.example.minh.model.request.SizeRequest;
import com.example.minh.model.response.ApiResponse;
import com.example.minh.service.BrandService;
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

@RestController
@RequestMapping("/api/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @PostMapping("/add")
    public ApiResponse<Brand> addBrand(@RequestBody @Valid BrandRequest brandRequest) {
        ApiResponse<Brand> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("add brand successfully!");
        apiResponse.setResult(brandService.addBrand(brandRequest));
        return apiResponse;
    }

    @PutMapping("/update/{id}")
    public ApiResponse<Brand> updateBrand(@RequestBody @Valid BrandRequest brandRequest, @PathVariable Long id) {
        ApiResponse<Brand> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("update brand successfully!");
        apiResponse.setResult(brandService.updateBrand(brandRequest, id));
        return apiResponse;
    }

    @GetMapping("/list")
    public ApiResponse<List<Brand>> getAllSizes() {
        ApiResponse<List<Brand>> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("get brand color!");
        apiResponse.setResult(brandService.getAllBrands());
        return apiResponse;
    }


}
