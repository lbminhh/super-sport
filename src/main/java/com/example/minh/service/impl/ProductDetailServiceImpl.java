package com.example.minh.service.impl;

import com.example.minh.entity.Color;
import com.example.minh.entity.Product;
import com.example.minh.entity.ProductDetail;
import com.example.minh.entity.Size;
import com.example.minh.exception.AppException;
import com.example.minh.mapper.ProductDetailMapper;
import com.example.minh.model.enums.ErrorCode;
import com.example.minh.model.request.ProductDetailRequest;
import com.example.minh.model.response.ProductDetailResponse;
import com.example.minh.repository.ColorRepository;
import com.example.minh.repository.ProductDetailRepository;
import com.example.minh.repository.ProductRepository;
import com.example.minh.repository.SizeRepository;
import com.example.minh.service.ProductDetailService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    ProductDetailRepository productDetailRepository;

    @Autowired
    ColorRepository colorRepository;

    @Autowired
    SizeRepository sizeRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductDetailMapper productDetailMapper;

    @Override
    public ProductDetailResponse addProductDetail(ProductDetailRequest productDetailRequest) {
        Size size = sizeRepository.findById(productDetailRequest.getSizeID())
                .orElseThrow(() -> new AppException(ErrorCode.SIZE_NOT_EXIST));

        Color color = colorRepository.findById(productDetailRequest.getColorID())
                .orElseThrow(() -> new AppException(ErrorCode.COLOR_NOT_EXIST));

        Product product = productRepository.findById(productDetailRequest.getProductID())
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXIST));

        //Nếu xuất hiện 1 product detail đã có trong database
        if (productDetailRepository.existsByColorAndProductAndSize(color, product, size)) {
            throw new AppException(ErrorCode.PRODUCT_DETAIL_IS_EXIST);
        }

        ProductDetail productDetail = productDetailMapper.toProductDetail(productDetailRequest);
        productDetail.setColor(color);
        productDetail.setSize(size);
        productDetail.setProduct(product);

        return productDetailMapper.toProductDetailResponse(productDetailRepository.save(productDetail));
    }

    @Override
    public ProductDetailResponse updateProductDetail(ProductDetailRequest productDetailRequest, UUID id) {
        Size size = sizeRepository.findById(productDetailRequest.getSizeID())
                .orElseThrow(() -> new AppException(ErrorCode.SIZE_NOT_EXIST));

        Color color = colorRepository.findById(productDetailRequest.getColorID())
                .orElseThrow(() -> new AppException(ErrorCode.COLOR_NOT_EXIST));

        Product product = productRepository.findById(productDetailRequest.getProductID())
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXIST));

        //Nếu xuất hiện 1 product detail đã có trong database
        if (productDetailRepository.existsByColorAndProductAndSize(color, product, size)) {
            System.out.println("okk");
            throw new AppException(ErrorCode.PRODUCT_DETAIL_IS_EXIST);
        }

        ProductDetail productDetail = productDetailMapper.toProductDetail(productDetailRequest);
        productDetail.setId(id);
        productDetail.setColor(color);
        productDetail.setSize(size);
        productDetail.setProduct(product);

        return productDetailMapper.toProductDetailResponse(productDetailRepository.save(productDetail));
    }

    @Override
    public List<ProductDetailResponse> getAllProducts() {
        List<ProductDetailResponse> list = new ArrayList<>();
        for (ProductDetail item : productDetailRepository.findAll()) {
            list.add(productDetailMapper.toProductDetailResponse(item));
        }
        return list;
    }
}
