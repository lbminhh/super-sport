package com.example.minh.service;

import com.example.minh.entity.AccountCustomer;
import com.example.minh.model.request.AccountCustomerRequest;

import java.util.List;
import java.util.UUID;

public interface AccountCustomerService {

    List<AccountCustomer> getAllAccountCustomers();

    AccountCustomer add(AccountCustomerRequest accountCustomerRequest);

    AccountCustomer update(AccountCustomerRequest accountCustomerRequest, UUID id);

}
