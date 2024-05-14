package com.example.minh.service.impl;

import com.example.minh.entity.Customer;
import com.example.minh.entity.CustomerCart;
import com.example.minh.entity.ProductDetail;
import com.example.minh.exception.AppException;
import com.example.minh.model.enums.ErrorCode;
import com.example.minh.model.keys.CustomerCartKey;
import com.example.minh.model.request.CustomerCartRequest;
import com.example.minh.repository.CustomerCartRepository;
import com.example.minh.repository.CustomerRepository;
import com.example.minh.repository.ProductDetailRepository;
import com.example.minh.service.CustomerCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class CustomerCartServiceImpl implements CustomerCartService {

    @Autowired
    private CustomerCartRepository customerCartRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public String add(CustomerCartRequest request) {
        Customer customer = customerRepository.findById(UUID.fromString(request.getCustomerID()))
                .orElseThrow(() -> new AppException(ErrorCode.CUSTOMER_NOT_EXIST));

        ProductDetail productDetail = productDetailRepository.findById(UUID.fromString(request.getProductDetailID()))
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_DETAIL_IS_EXIST));

        if (customerCartRepository.existsByCustomerAndProductDetail(customer, productDetail)) {
            throw new AppException(ErrorCode.PRODUCT_IS_ALREADY_EXIST_IN_CART_PRODUCT_CUSTOMER);
        }

        CustomerCartKey customerCartKey = CustomerCartKey.builder()
                .customerID(UUID.fromString(request.getCustomerID()))
                .productDetailID(UUID.fromString(request.getProductDetailID()))
                .build();

        CustomerCart customerCart = customerCartRepository.save(CustomerCart.builder()
                .customer(customer)
                .productDetail(productDetail)
                .customerCartKey(customerCartKey)
                .quantity(request.getQuantity())
                .totalMoney(productDetail.getPrice().multiply(BigDecimal.valueOf((double) request.getQuantity())))
                .build());

        System.out.println();

        return customerCart != null ? "add product to customer cart successfully!" : "failed";
    }

    @Override
    public String update(CustomerCartRequest request) {
        Customer customer = customerRepository.findById(UUID.fromString(request.getCustomerID()))
                .orElseThrow(() -> new AppException(ErrorCode.CUSTOMER_NOT_EXIST));

        ProductDetail productDetail = productDetailRepository.findById(UUID.fromString(request.getProductDetailID()))
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_DETAIL_IS_EXIST));

        if (!customerCartRepository.existsByCustomerAndProductDetail(customer, productDetail)) {
            throw new AppException(ErrorCode.PRODUCT_OR_CUSTOMER_NOT_EXIST);
        }

        CustomerCartKey customerCartKey = CustomerCartKey.builder()
                .customerID(UUID.fromString(request.getCustomerID()))
                .productDetailID(UUID.fromString(request.getProductDetailID()))
                .build();

        CustomerCart customerCart = customerCartRepository.save(CustomerCart.builder()
                .customer(customer)
                .productDetail(productDetail)
                .customerCartKey(customerCartKey)
                .totalMoney(productDetail.getPrice().multiply(BigDecimal.valueOf((double) request.getQuantity())))
                .quantity(request.getQuantity())
                .build());

        return customerCart != null ? "add product to customer cart successfully!" : "failed";
    }

    @Override
    public String delete(CustomerCartRequest request) {
        Customer customer = customerRepository.findById(UUID.fromString(request.getCustomerID()))
                .orElseThrow(() -> new AppException(ErrorCode.CUSTOMER_NOT_EXIST));

        ProductDetail productDetail = productDetailRepository.findById(UUID.fromString(request.getProductDetailID()))
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_DETAIL_IS_EXIST));

        if (!customerCartRepository.existsByCustomerAndProductDetail(customer, productDetail)) {
            throw new AppException(ErrorCode.PRODUCT_OR_CUSTOMER_NOT_EXIST);
        }

        CustomerCartKey customerCartKey = CustomerCartKey.builder()
                .customerID(UUID.fromString(request.getCustomerID()))
                .productDetailID(UUID.fromString(request.getProductDetailID()))
                .build();

        CustomerCart customerCart = CustomerCart.builder()
                .customer(customer)
                .productDetail(productDetail)
                .customerCartKey(customerCartKey)
                .build();

        customerCartRepository.delete(customerCart);

        return customerCart != null ? "delete product to customer cart successfully!" : "failed";
    }
}
