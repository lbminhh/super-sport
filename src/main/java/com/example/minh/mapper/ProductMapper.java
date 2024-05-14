package com.example.minh.mapper;

import com.example.minh.entity.Product;
import com.example.minh.model.request.ProductRequest;
import com.example.minh.model.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "colors",ignore = true)
    @Mapping(target = "objectUses", ignore = true)
    @Mapping(target = "subCategoryName", source = "subCategory.subCateName")
    @Mapping(target = "brandName", source = "brand.brandName")
    ProductResponse toProductResponse(Product product);
//
    @Mapping(target = "colors", ignore = true)
    @Mapping(target = "objectUses", ignore = true)
    Product toProduct(ProductRequest productRequest);


}
