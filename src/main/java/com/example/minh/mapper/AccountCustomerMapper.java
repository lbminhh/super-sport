package com.example.minh.mapper;

import com.example.minh.entity.AccountCustomer;
import com.example.minh.model.request.AccountCustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountCustomerMapper {

    AccountCustomer toAccountCustomer(AccountCustomerRequest accountCustomerRequest);

}
