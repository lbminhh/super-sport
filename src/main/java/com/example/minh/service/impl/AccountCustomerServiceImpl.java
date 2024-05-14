package com.example.minh.service.impl;

import com.example.minh.entity.AccountCustomer;
import com.example.minh.entity.Customer;
import com.example.minh.entity.Role;
import com.example.minh.exception.AppException;
import com.example.minh.mapper.AccountCustomerMapper;
import com.example.minh.model.enums.ERole;
import com.example.minh.model.enums.ErrorCode;
import com.example.minh.model.request.AccountCustomerRequest;
import com.example.minh.repository.AccountCustomerRepository;
import com.example.minh.repository.CustomerRepository;
import com.example.minh.repository.RoleRepository;
import com.example.minh.service.AccountCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountCustomerServiceImpl implements AccountCustomerService {

    @Autowired
    private AccountCustomerRepository accountCustomerRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AccountCustomerMapper accountCustomerMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<AccountCustomer> getAllAccountCustomers() {
        return accountCustomerRepository.findAll();
    }

    @Override
    public AccountCustomer add(AccountCustomerRequest accountCustomerRequest) {
        Customer customer = customerRepository.findById(accountCustomerRequest.getCustomerID())
                .orElseThrow(() -> new AppException(ErrorCode.CUSTOMER_NOT_EXIST));

        if (accountCustomerRepository.existsByCustomer(customer)) {
            throw new AppException(ErrorCode.CUSTOMER_ACCOUNT_IS_EXIST);
        }

        Role role = roleRepository.findByRoleName(ERole.CUSTOMER);

        if (role == null) {
            role = roleRepository.save(new Role(null, ERole.CUSTOMER));
            System.out.println("okk");
        }

        AccountCustomer accountCustomer = accountCustomerMapper.toAccountCustomer(accountCustomerRequest);
        accountCustomer.setRole(role);
        accountCustomer.setCustomer(customer);
        accountCustomer.setPassword(passwordEncoder.encode(accountCustomerRequest.getPassword()));
        System.out.println(accountCustomer);
        return accountCustomerRepository.save(accountCustomer);
    }

    @Override
    public AccountCustomer update(AccountCustomerRequest accountCustomerRequest, UUID id) {
        Customer customer = customerRepository.findById(accountCustomerRequest.getCustomerID())
                .orElseThrow(() -> new AppException(ErrorCode.CUSTOMER_NOT_EXIST));

        if (!accountCustomerRepository.existsByCustomer(customer)) {
            throw new AppException(ErrorCode.CUSTOMER_ACCOUNT_NOT_EXIST);
        }

        Role role = roleRepository.findByRoleName(ERole.CUSTOMER);


        AccountCustomer accountCustomer = accountCustomerMapper.toAccountCustomer(accountCustomerRequest);
        accountCustomer.setCustomer(customer);
        accountCustomer.setRole(role);
        return accountCustomerRepository.save(accountCustomer);
    }
}
