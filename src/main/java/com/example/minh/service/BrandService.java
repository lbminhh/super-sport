package com.example.minh.service;

import com.example.minh.entity.Brand;
import com.example.minh.entity.Color;
import com.example.minh.model.request.BrandRequest;
import com.example.minh.model.request.ColorRequest;

import java.util.List;

public interface BrandService {

    List<Brand> getAllBrands();

    Brand addBrand(BrandRequest brandRequest);

    Brand updateBrand(BrandRequest brandRequest, Long id);

}
