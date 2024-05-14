package com.example.minh.service;

import com.example.minh.entity.CustomerAddress;
import com.example.minh.model.request.CustomerAddressRequest;

import java.util.List;

public interface CustomerAddressService {

    List<CustomerAddress> getAllCustomerAddress();

    String add(CustomerAddressRequest customerAddressRequest);

    String update(CustomerAddressRequest customerAddressRequest,Long id);

}
