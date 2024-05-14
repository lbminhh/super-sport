package com.example.minh.repository;

import com.example.minh.entity.Customer;
import com.example.minh.entity.CustomerCart;
import com.example.minh.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerCartRepository extends JpaRepository<CustomerCart, UUID> {

    boolean existsByCustomerAndProductDetail(Customer customer, ProductDetail productDetail);

}
