package com.example.minh.repository;

import com.example.minh.entity.AccountCustomer;
import com.example.minh.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountCustomerRepository extends JpaRepository<AccountCustomer, UUID> {

    boolean existsByCustomer(Customer customer);

}
