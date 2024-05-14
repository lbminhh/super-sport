package com.example.minh.service.impl;

import com.example.minh.entity.Customer;
import com.example.minh.entity.Product;
import com.example.minh.exception.AppException;
import com.example.minh.mapper.CustomerMapper;
import com.example.minh.model.enums.ErrorCode;
import com.example.minh.model.request.CustomerRequest;
import com.example.minh.model.response.CustomerResponse;
import com.example.minh.repository.CustomerRepository;
import com.example.minh.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> getAllCustomers() {
        List<CustomerResponse> list = new ArrayList<>();
        for(Customer item : customerRepository.findAll()) {
            list.add(customerMapper.toCustomerResponse(item));
        }
        return customerRepository.findAll();
    }

    @Override
    public CustomerResponse add(CustomerRequest customerRequest) {
        customerRepository.deleteAll();
        Customer customer = customerMapper.toCustomer(customerRequest);
        return customerMapper.toCustomerResponse(customerRepository.save(customer));
    }

    @Override
    public CustomerResponse update(CustomerRequest customerRequest, UUID id) {
        if (!customerRepository.existsById(id)) {
            throw new AppException(ErrorCode.CUSTOMER_NOT_EXIST);
        }

        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        return customerMapper.toCustomerResponse(customerRepository.save(customer));
    }
}
