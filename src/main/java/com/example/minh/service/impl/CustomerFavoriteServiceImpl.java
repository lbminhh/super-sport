package com.example.minh.service.impl;

import com.example.minh.entity.Customer;
import com.example.minh.entity.CustomerFavorite;
import com.example.minh.entity.ProductDetail;
import com.example.minh.exception.AppException;
import com.example.minh.model.enums.ErrorCode;
import com.example.minh.model.keys.CustomerFavoriteKey;
import com.example.minh.model.request.CustomerFavoriteRequest;
import com.example.minh.repository.CustomerFavoriteRepository;
import com.example.minh.repository.CustomerRepository;
import com.example.minh.repository.ProductDetailRepository;
import com.example.minh.service.CustomerFavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerFavoriteServiceImpl implements CustomerFavoriteService {

    @Autowired
    private CustomerFavoriteRepository customerFavoriteRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public String add(CustomerFavoriteRequest customerFavoriteRequest) {

        Customer customer = customerRepository.findById(UUID.fromString(customerFavoriteRequest.getCustomerID()))
                .orElseThrow(() -> new AppException(ErrorCode.CUSTOMER_NOT_EXIST));

        ProductDetail productDetail = productDetailRepository.findById(UUID.fromString(customerFavoriteRequest.getProductDetailID()))
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_DETAIL_IS_EXIST));

        if (customerFavoriteRepository.existsByCustomerAndProductDetail(customer, productDetail)) {
            throw new AppException(ErrorCode.PRODUCT_IS_ALREADY_EXIST_IN_FAVORITE_PRODUCT_CUSTOMER);
        }

        CustomerFavoriteKey customerFavoriteKey = CustomerFavoriteKey.builder()
                .customerID(UUID.fromString(customerFavoriteRequest.getCustomerID()))
                .productDetailID(UUID.fromString(customerFavoriteRequest.getProductDetailID()))
                .build();

        CustomerFavorite customerFavorite = customerFavoriteRepository.save(CustomerFavorite.builder()
                .customer(customer)
                .productDetail(productDetail)
                .customerFavoriteKey(customerFavoriteKey)
                .build());

        customerFavoriteRepository.save(customerFavorite);

        return customerFavorite != null ? "add product to customer favorite successfully!" : "failed";
    }

    @Override
    public String delete(CustomerFavoriteRequest customerFavoriteRequest) {

        Customer customer = customerRepository.findById(UUID.fromString(customerFavoriteRequest.getCustomerID()))
                .orElseThrow(() -> new AppException(ErrorCode.CUSTOMER_NOT_EXIST));

        ProductDetail productDetail = productDetailRepository.findById(UUID.fromString(customerFavoriteRequest.getProductDetailID()))
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_DETAIL_IS_EXIST));

        if (!customerFavoriteRepository.existsByCustomerAndProductDetail(customer, productDetail)) {
            throw new AppException(ErrorCode.PRODUCT_OR_CUSTOMER_NOT_EXIST);
        }

        CustomerFavoriteKey customerFavoriteKey = CustomerFavoriteKey.builder()
                .productDetailID(UUID.fromString(customerFavoriteRequest.getProductDetailID()))
                .customerID(UUID.fromString(customerFavoriteRequest.getCustomerID()))
                .build();

        CustomerFavorite customerFavorite = customerFavoriteRepository
                .save(CustomerFavorite.builder()
                        .customer(customer)
                        .productDetail(productDetail)
                        .customerFavoriteKey(customerFavoriteKey)
                        .build());

        customerFavoriteRepository.delete(customerFavorite);
        return "delete customer favorite successfully!";
    }
}
