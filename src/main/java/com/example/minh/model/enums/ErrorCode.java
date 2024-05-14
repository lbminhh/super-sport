package com.example.minh.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    COLOR_NOT_EXIST(999, "Color does not exist!"),
    CATEGORY_NOT_EXIST(999, "Category does exist!"),
    SUB_CATEGORY_NOT_EXIST(999, "SubCategory does not exist!"),
    SIZE_NOT_EXIST(999, "Size does not exist!"),
    OBJECT_USE_NOT_EXIST(999, "object use does not exist!"),
    BRAND_NOT_EXIST(999, "brand does not exist!"),
    PRODUCT_NOT_EXIST(999, "product does not exist!"),
    PRODUCT_DETAIL_IS_EXIST(999, "product-detail does exist!"),
    PRODUCT_DETAIL_NOT_EXIST(999, "product-detail does not exist!"),
    IMAGE_IS_NOT_EXIST(999, "image does not exist!"),
    IMAGE_IS_NOT_AVAILABLE(999, "image is not available!"),
    FAIL_UPLOAD_TO_CLOUDINARY(999, "fail upload to cloudinary!"),
    CUSTOMER_NOT_EXIST(999, "customer does not exist!"),
    CUSTOMER_ADDRESS_NOT_EXIST(999, "customer address does not exist!"),
    CUSTOMER_ACCOUNT_IS_EXIST(999, "customer account does exist!"),
    CUSTOMER_ACCOUNT_NOT_EXIST(999, "customer account does not exist!"),
    PRODUCT_IS_ALREADY_EXIST_IN_FAVORITE_PRODUCT_CUSTOMER(999, "product is already exist in customer favorite!"),
    PRODUCT_OR_CUSTOMER_NOT_EXIST(999, "product or customer not exist"),
    PRODUCT_IS_ALREADY_EXIST_IN_CART_PRODUCT_CUSTOMER(999, "product is already exist in customer cart!"),
    ;
    private int code;

    private String message;

}
