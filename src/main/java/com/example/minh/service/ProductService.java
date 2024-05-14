package com.example.minh.service;

import com.example.minh.model.request.ProductRequest;
import com.example.minh.model.response.ProductResponse;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    ProductResponse addProduct(ProductRequest productRequest);

    ProductResponse update(ProductRequest productRequest, UUID id);

    List<ProductResponse> getAllProducts();

}
