package com.example.minh.mapper;

import com.example.minh.entity.CustomerAddress;
import com.example.minh.model.request.CustomerAddressRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerAddressMapper {

    CustomerAddress toCustomerAddress(CustomerAddressRequest customerAddressRequest);

}
