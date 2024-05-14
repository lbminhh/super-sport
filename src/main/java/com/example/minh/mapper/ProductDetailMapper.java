package com.example.minh.mapper;

import com.example.minh.entity.ProductDetail;
import com.example.minh.model.request.ProductDetailRequest;
import com.example.minh.model.response.ProductDetailResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductDetailMapper {

    ProductDetail toProductDetail(ProductDetailRequest productDetailRequest);

    @Mapping(target = "sizeName", source = "size.sizeName")
    @Mapping(target = "colorName", source = "color.colorName")
    @Mapping(target = "productName", source = "product.productName")
    ProductDetailResponse toProductDetailResponse(ProductDetail productDetail);

}
