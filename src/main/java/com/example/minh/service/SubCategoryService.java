package com.example.minh.service;

import com.example.minh.entity.Category;
import com.example.minh.entity.SubCategory;
import com.example.minh.model.request.CategoryRequest;
import com.example.minh.model.request.SubCategoryRequest;

import java.util.List;

public interface SubCategoryService {

    List<SubCategory> getAllSubCategories();

    SubCategory addSubCategory(SubCategoryRequest subCategoryRequest);

    SubCategory updateSubCategory(SubCategoryRequest subCategoryRequest, Long id);

}
