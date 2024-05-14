package com.example.minh.entity;

import com.example.minh.model.keys.CustomerEvaluateKey;
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
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "customer_evalute")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerEvaluate {

    @EmbeddedId
    CustomerEvaluateKey customerEvaluteKey;

    @ManyToOne
    @MapsId("customerID")
    @JoinColumn(name = "customer_id")
    Customer customer;

    @ManyToOne
    @MapsId("evaluteID")
    @JoinColumn(name = "evalute_id")
    Evaluate evalute;

    String method;

    @Column(name = "time_create")
    @CreationTimestamp
    Date timeCreate;
}
