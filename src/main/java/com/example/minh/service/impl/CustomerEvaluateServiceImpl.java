package com.example.minh.service.impl;

import com.example.minh.entity.Customer;
import com.example.minh.entity.CustomerEvaluate;
import com.example.minh.entity.Evaluate;
import com.example.minh.entity.ProductDetail;
import com.example.minh.exception.AppException;
import com.example.minh.model.enums.ErrorCode;
import com.example.minh.model.keys.CustomerEvaluateKey;
import com.example.minh.model.request.EvaluateRequest;
import com.example.minh.repository.CustomerEvaluateRepository;
import com.example.minh.repository.CustomerRepository;
import com.example.minh.repository.EvaluteRepository;
import com.example.minh.repository.ProductDetailRepository;
import com.example.minh.service.CustomerEvaluteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerEvaluateServiceImpl implements CustomerEvaluteService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EvaluteRepository evaluteRepository;

    @Autowired
    private CustomerEvaluateRepository customerEvaluateRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public Evaluate add(EvaluateRequest request) {
        Customer customer = customerRepository.findById(UUID.fromString(request.getCustomerID()))
                .orElseThrow(() -> new AppException(ErrorCode.CUSTOMER_NOT_EXIST));

        ProductDetail productDetail = productDetailRepository.findById(UUID.fromString(request.getProductDetailID()))
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_DETAIL_NOT_EXIST));
        //THêm đánh giá vào DB
        Evaluate evaluate = evaluteRepository.save(Evaluate.builder()
                .comment(request.getComment())
                .likeCount(0)
                .dislikeCount(0)
                .productDetail(productDetail)
                .rating(request.getRating())
                .build());

        CustomerEvaluateKey customerEvaluateKey = CustomerEvaluateKey.builder()
                .customerID(UUID.fromString(request.getCustomerID()))
                .evaluteID(evaluate.getId())
                .build();

        CustomerEvaluate customerEvaluate = customerEvaluateRepository
                .save(CustomerEvaluate.builder()
                .customer(customer)
                .customerEvaluteKey(customerEvaluateKey)
                .evalute(evaluate)
                .method("comment")
                .build());
        return evaluate;
    }

    @Override
    public Evaluate update(EvaluateRequest request, Long id) {
        return null;
    }

    @Override
    public Evaluate delete(Long id) {
        return null;
    }
}
