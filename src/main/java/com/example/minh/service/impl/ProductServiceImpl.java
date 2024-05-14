package com.example.minh.service.impl;

import com.example.minh.entity.Brand;
import com.example.minh.entity.Color;
import com.example.minh.entity.ObjectUse;
import com.example.minh.entity.Product;
import com.example.minh.entity.SubCategory;
import com.example.minh.exception.AppException;
import com.example.minh.mapper.ProductMapper;
import com.example.minh.model.enums.ErrorCode;
import com.example.minh.model.request.ProductRequest;
import com.example.minh.model.response.ProductResponse;
import com.example.minh.repository.BrandRepository;
import com.example.minh.repository.ColorRepository;
import com.example.minh.repository.ObjectUseRepository;
import com.example.minh.repository.ProductRepository;
import com.example.minh.repository.SubCategoryRepository;
import com.example.minh.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private ObjectUseRepository objectUseRepository;

    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {

        Brand brand = brandRepository.findById(productRequest.getBrandID())
                .orElseThrow(() -> new AppException(ErrorCode.BRAND_NOT_EXIST));

        SubCategory subCategory = subCategoryRepository.findById(productRequest.getSubCategoryID())
                .orElseThrow(() -> new AppException(ErrorCode.SUB_CATEGORY_NOT_EXIST));

        Set<Color> colors = new HashSet<>();
        for (String item : productRequest.getColors()) {
            Color color = colorRepository.findColorByColorName(item)
                    .orElseThrow(() -> new AppException(ErrorCode.COLOR_NOT_EXIST));
            colors.add(color);
        }

        Set<ObjectUse> objectUses = new HashSet<>();
        for (String item : productRequest.getObjectUses()) {
            ObjectUse objectUse = objectUseRepository.findObjectUseByObjectUseName(item)
                    .orElseThrow(() -> new AppException(ErrorCode.OBJECT_USE_NOT_EXIST));
            objectUses.add(objectUse);
        }

        Product product = productMapper.toProduct(productRequest);
        product.setColors(colors);
        product.setObjectUses(objectUses);
        product.setBrand(brand);
        product.setSubCategory(subCategory);

        ProductResponse productResponse = productMapper.toProductResponse(productRepository.save(product));
        productResponse.setColors(colorRepository.findColorByProductId(productResponse.getId()));
        productResponse.setObjectUses(objectUseRepository.findObjectUseByProductId(productResponse.getId()));

        return productResponse;
    }

    @Override
    public ProductResponse update(ProductRequest productRequest, UUID id) {
        Brand brand = brandRepository.findById(productRequest.getBrandID())
                .orElseThrow(() -> new AppException(ErrorCode.BRAND_NOT_EXIST));

        SubCategory subCategory = subCategoryRepository.findById(productRequest.getSubCategoryID())
                .orElseThrow(() -> new AppException(ErrorCode.SUB_CATEGORY_NOT_EXIST));

        Set<Color> colors = new HashSet<>();
        for (String item : productRequest.getColors()) {
            Color color = colorRepository.findColorByColorName(item)
                    .orElseThrow(() -> new AppException(ErrorCode.COLOR_NOT_EXIST));
            colors.add(color);
        }

        Set<ObjectUse> objectUses = new HashSet<>();
        for (String item : productRequest.getObjectUses()) {
            ObjectUse objectUse = objectUseRepository.findObjectUseByObjectUseName(item)
                    .orElseThrow(() -> new AppException(ErrorCode.OBJECT_USE_NOT_EXIST));
            objectUses.add(objectUse);
        }

        Product product = productMapper.toProduct(productRequest);
        product.setId(id);
        product.setColors(colors);
        product.setObjectUses(objectUses);
        product.setBrand(brand);
        product.setSubCategory(subCategory);

        ProductResponse productResponse = productMapper.toProductResponse(productRepository.save(product));
        productResponse.setColors(colorRepository.findColorByProductId(productResponse.getId()));
        productResponse.setObjectUses(objectUseRepository.findObjectUseByProductId(productResponse.getId()));

        return productResponse;
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<ProductResponse> list = new ArrayList<>();

        for (Product item : productRepository.findAll()) {
            System.out.println(item);
            ProductResponse productResponse = productMapper.toProductResponse(item);
            //Lấy ra list color của product đó
            productResponse.setColors(colorRepository.findColorByProductId(item.getId()));
            //Lấy ra list object-use của product đó
            productResponse.setObjectUses(objectUseRepository.findObjectUseByProductId(item.getId()));

            list.add(productResponse);
        }

        return list;
    }
}
