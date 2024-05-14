package com.example.minh.repository;

import com.example.minh.entity.Color;
import com.example.minh.entity.Product;
import com.example.minh.entity.ProductDetail;
import com.example.minh.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, UUID> {

    boolean existsByColorAndProductAndSize(Color color, Product product, Size size);

}
