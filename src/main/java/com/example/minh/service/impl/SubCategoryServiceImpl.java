package com.example.minh.service.impl;

import com.example.minh.entity.Category;
import com.example.minh.entity.SubCategory;
import com.example.minh.exception.AppException;
import com.example.minh.model.enums.ErrorCode;
import com.example.minh.model.request.SubCategoryRequest;
import com.example.minh.repository.CategoryRepository;
import com.example.minh.repository.SubCategoryRepository;
import com.example.minh.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    SubCategoryRepository subCategoryRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    @Override
    public SubCategory addSubCategory(SubCategoryRequest subCategoryRequest) {
        Category category = categoryRepository.findById(subCategoryRequest.getCategoryID())
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_EXIST));
        SubCategory subCategory = SubCategory.builder()
                .subCateName(subCategoryRequest.getSubCategoryName())
                .description(subCategoryRequest.getDescription())
                .category(category)
                .build();
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public SubCategory updateSubCategory(SubCategoryRequest subCategoryRequest, Long id) {
        Category category = categoryRepository.findById(subCategoryRequest.getCategoryID())
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_EXIST));
        SubCategory subCategory = subCategoryRepository.findById(id)
                .orElseThrow(() -> new  AppException(ErrorCode.SUB_CATEGORY_NOT_EXIST));

        subCategory.setSubCateName(subCategoryRequest.getSubCategoryName());
        subCategory.setDescription(subCategoryRequest.getDescription());
        subCategory.setCategory(category);

        return subCategoryRepository.save(subCategory);
    }
}
