package com.example.minh.service;

import com.example.minh.entity.Category;
import com.example.minh.entity.Color;
import com.example.minh.model.request.CategoryRequest;
import com.example.minh.model.request.ColorRequest;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category addCategory(CategoryRequest categoryRequest);

    Category updateCategory(CategoryRequest categoryRequest, Long id);

}
