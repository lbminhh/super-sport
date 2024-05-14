package com.example.minh.entity;

import com.example.minh.model.keys.CustomerCartKey;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@Table(name = "customer_cart")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerCart {

    @EmbeddedId
    CustomerCartKey customerCartKey;

    @ManyToOne
    @MapsId("productDetailID")
    @JoinColumn(name = "product_detail_id")
    ProductDetail productDetail;

    @ManyToOne
    @MapsId("customerID")
    @JoinColumn(name = "customer_id")
    Customer customer;

    Integer quantity;

    @Column(name = "total_money")
    BigDecimal totalMoney;
}
