package com.example.minh.service;

import com.example.minh.entity.Category;
import com.example.minh.entity.Size;
import com.example.minh.model.request.CategoryRequest;
import com.example.minh.model.request.SizeRequest;

import java.util.List;

public interface SizeService {

    List<Size> getAllSizes();

    Size addSize(SizeRequest sizeRequest);

    Size updateSize(SizeRequest sizeRequest, Long id);
}
