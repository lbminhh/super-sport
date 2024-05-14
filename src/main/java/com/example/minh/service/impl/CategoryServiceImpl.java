package com.example.minh.service.impl;

import com.example.minh.entity.Category;
import com.example.minh.exception.AppException;
import com.example.minh.model.enums.ErrorCode;
import com.example.minh.model.request.CategoryRequest;
import com.example.minh.repository.CategoryRepository;
import com.example.minh.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setCategoryName(categoryRequest.getCategoryName());
        category.setDescription(categoryRequest.getDescription());
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(CategoryRequest categoryRequest, Long id) {

        if (!categoryRepository.existsById(id)) {
            throw new AppException(ErrorCode.CATEGORY_NOT_EXIST);
        }
        Category category = new Category();
        category.setId(id);
        category.setCategoryName(categoryRequest.getCategoryName());
        category.setDescription(categoryRequest.getDescription());
        return categoryRepository.save(category);
    }
}
