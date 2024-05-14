package com.example.minh.controller;

import com.example.minh.entity.SubCategory;
import com.example.minh.model.request.SubCategoryRequest;
import com.example.minh.model.response.ApiResponse;
import com.example.minh.service.SubCategoryService;
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
@RequestMapping("/api/sub-category")
public class SubCategoryController {

    @Autowired
    SubCategoryService subCategoryService;

    @PostMapping("/add")
    public ApiResponse<SubCategory> addCategory(@RequestBody @Valid SubCategoryRequest subCategoryRequest) {
        ApiResponse<SubCategory> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("add sub-category succesfully!");
        apiResponse.setResult(subCategoryService.addSubCategory(subCategoryRequest));
        return apiResponse;
    }

    @PutMapping("/update/{id}")
    public ApiResponse<SubCategory> updateCategory(@RequestBody @Valid SubCategoryRequest subCategoryRequest, @PathVariable Long id) {
        ApiResponse<SubCategory> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("update sub-category succesfully!");
        apiResponse.setResult(subCategoryService.updateSubCategory(subCategoryRequest, id));
        return apiResponse;
    }

    @GetMapping("/list")
    public ApiResponse<List<SubCategory>> getAllCategories() {
        ApiResponse<List<SubCategory>> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("get all category!");
        apiResponse.setResult(subCategoryService.getAllSubCategories());
        return apiResponse;
    }
}
