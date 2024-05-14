package com.example.minh.mapper;

import com.example.minh.entity.Customer;
import com.example.minh.model.request.CustomerRequest;
import com.example.minh.model.response.CustomerResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerResponse toCustomerResponse(Customer customer);

    Customer toCustomer(CustomerRequest customerRequest);

}
