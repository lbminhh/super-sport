package com.example.minh.controller;

import com.example.minh.entity.Category;
import com.example.minh.model.request.CategoryRequest;
import com.example.minh.model.response.ApiResponse;
import com.example.minh.service.CategoryService;
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
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    public ApiResponse<Category> addCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        ApiResponse<Category> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("add category succesfully!");
        apiResponse.setResult(categoryService.addCategory(categoryRequest));
        return apiResponse;
    }

    @PutMapping("/update/{id}")
    public ApiResponse<Category> updateCategory(@RequestBody @Valid CategoryRequest categoryRequest, @PathVariable Long id) {
        ApiResponse<Category> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("update color succesfully!");
        apiResponse.setResult(categoryService.updateCategory(categoryRequest, id));
        return apiResponse;
    }

    @GetMapping("/list")
    public ApiResponse<List<Category>> getAllCategories() {
        ApiResponse<List<Category>> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("get all category!");
        apiResponse.setResult(categoryService.getAllCategories());
        return apiResponse;
    }
}
