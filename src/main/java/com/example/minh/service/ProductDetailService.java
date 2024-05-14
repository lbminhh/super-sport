package com.example.minh.service;

import com.example.minh.model.request.ProductDetailRequest;
import com.example.minh.model.response.ProductDetailResponse;

import java.util.List;
import java.util.UUID;

public interface ProductDetailService {

    ProductDetailResponse addProductDetail(ProductDetailRequest productDetailRequest);

    ProductDetailResponse updateProductDetail(ProductDetailRequest productDetailRequest, UUID id);

    List<ProductDetailResponse> getAllProducts();

}
