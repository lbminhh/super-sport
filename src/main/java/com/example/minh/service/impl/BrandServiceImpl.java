package com.example.minh.service.impl;

import com.example.minh.entity.Brand;
import com.example.minh.exception.AppException;
import com.example.minh.model.enums.ErrorCode;
import com.example.minh.model.request.BrandRequest;
import com.example.minh.repository.BrandRepository;
import com.example.minh.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand addBrand(BrandRequest brandRequest) {
        Brand brand = Brand.builder()
                .brandName(brandRequest.getBrandName())
                .description(brandRequest.getDescription())
                .build();
        return brandRepository.save(brand);
    }

    @Override
    public Brand updateBrand(BrandRequest brandRequest, Long id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.BRAND_NOT_EXIST));

        brand.setBrandName(brandRequest.getBrandName());
        brand.setDescription(brandRequest.getDescription());

        return brandRepository.save(brand);
    }
}
