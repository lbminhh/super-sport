package com.example.minh.entity;

import com.example.minh.entity.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "customer_address")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "`province`")
    String province;

    @Column(name = "`city`")
    String city;

    @Column(name = "`district`")
    String district;

    @Column(name = "`street_address`")
    String streetAddress;

    @Column(name = "is_active")
    Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
}
