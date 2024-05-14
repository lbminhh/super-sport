package com.example.minh.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {

    @NotNull(message = "totalMoney can not be null!")
    @Min(value = 0, message = "total money must be greater than 0!")
    BigDecimal totalMoney;

    @NotNull(message = "reduce money can not be null!")
    @Min(value = 0, message = "reduce money must be greater than 0!")
    BigDecimal reduceMoney;

    @NotNull(message = "totalMoney can not be null!")
    Integer status;

    @NotNull(message = "description can not be null!")
    String description;

    @NotNull(message = "totalMoney can not be null!")
    @Min(value = 1, message = "total quantity must be greater than 0")
    Integer totalQuantity;

    @NotNull(message = "shipping full name can not be null!")
    String shippingFullname;

    @NotNull(message = "shipping province can not be null!")
    String shippingProvince;

    @NotNull(message = "shipping city can not be null!")
    String shippingCity;

    @NotNull(message = "shipping district can not be null!")
    String shippingDistrict;

    @NotNull(message = "shipping street address can not be null!")
    String shippingStreetAddress;

    @NotNull(message = "employee id can not be null!")
    UUID employeeId;

    @NotNull(message = "customer id can not be null!")
    UUID customerId;

    @NotNull(message = "voucher id can not be null!")
    UUID voucherId;
}
