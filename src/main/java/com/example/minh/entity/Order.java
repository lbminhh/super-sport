package com.example.minh.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "`order`")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @Column(length = 36)
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "`total_money`")
    BigDecimal totalMoney;

    @Column(name = "`reduce_money`")
    BigDecimal reduceMoney;

    @Column(name = "order_status")
    Integer status;

    @Column(name = "`total_quantity`")
    Integer totalQuantity;

    @Column(name = "`order_description`")
    String description;

    @Column(name = "`shipping_fullname`")
    String shippingFullname;

    @Column(name = "`shipping_province`")
    String shippingProvince;

    @Column(name = "`shipping_city`")
    String shippingCity;

    @Column(name = "`shipping_district`")
    String shippingDistrict;

    @Column(name = "`shipping_street_address`")
    String shippingStreetAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`employee_id`")
    Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`customer_id`")
    Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "`voucher_id`")
    Voucher voucher;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<OrderDetail> orderDetails = new ArrayList<>();


}
