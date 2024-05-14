package com.example.minh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "voucher")
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Voucher {

    @Id
    @Column(length = 36)
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @Column(name = "voucher_code")
    String voucherCode;

    @Column(name = "voucher_name")
    String name;

    @Column(name = "voucher_value")
    BigDecimal value;

    @Column(name = "voucher_condition")
    BigDecimal condition;

    @Column(name = "voucher_status")
    Integer status;

    @Column(name = "time_start")
    @Temporal(TemporalType.TIMESTAMP)
    Date timeStart;

    @Column(name = "time_end")
    @Temporal(TemporalType.TIMESTAMP)
    Date timeEnd;
}
