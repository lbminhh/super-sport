package com.example.minh.service;

import com.example.minh.entity.Category;
import com.example.minh.entity.Customer;
import com.example.minh.model.request.CategoryRequest;
import com.example.minh.model.request.CustomerRequest;
import com.example.minh.model.response.CustomerResponse;

import java.util.List;
import java.util.UUID;

public interface CustomerService {

    List<Customer> getAllCustomers();

    CustomerResponse add(CustomerRequest customerRequest);

    CustomerResponse update(CustomerRequest customerRequest, UUID id);


}
