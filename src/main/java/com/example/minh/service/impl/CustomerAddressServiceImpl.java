package com.example.minh.service.impl;

import com.example.minh.entity.Customer;
import com.example.minh.entity.CustomerAddress;
import com.example.minh.exception.AppException;
import com.example.minh.mapper.CustomerAddressMapper;
import com.example.minh.model.enums.ErrorCode;
import com.example.minh.model.request.CustomerAddressRequest;
import com.example.minh.repository.CustomerAddressRepository;
import com.example.minh.repository.CustomerRepository;
import com.example.minh.service.CustomerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAddressServiceImpl implements CustomerAddressService {

    @Autowired
    private CustomerAddressRepository customerAddressRepository;

    @Autowired
    private CustomerAddressMapper customerAddressMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerAddress> getAllCustomerAddress() {
        return customerAddressRepository.findAll();
    }

    @Override
    public String add(CustomerAddressRequest customerAddressRequest) {

        Customer customer = customerRepository.findById(customerAddressRequest.getCustomerID())
                .orElseThrow(() -> new AppException(ErrorCode.CUSTOMER_NOT_EXIST));

        CustomerAddress customerAddress = customerAddressRepository.save(customerAddressMapper.toCustomerAddress(customerAddressRequest));
        customerAddress.setCustomer(customer);
        return customerAddress != null ? "Add customer address successfully!" : "failed to add customer address";
    }

    @Override
    public String update(CustomerAddressRequest customerAddressRequest, Long id) {
        Customer customer = customerRepository.findById(customerAddressRequest.getCustomerID())
                .orElseThrow(() -> new AppException(ErrorCode.CUSTOMER_NOT_EXIST));

        if (!customerAddressRepository.existsById(id)) {
            throw new AppException(ErrorCode.CUSTOMER_ADDRESS_NOT_EXIST);
        }

        CustomerAddress customerAddress = customerAddressMapper.toCustomerAddress(customerAddressRequest);
        customerAddress.setCustomer(customer);
        customerAddress.setId(id);
        return customerAddressRepository.save(customerAddress) != null ? "update customer address successfully!" : "failed to update customer address";
    }
}
