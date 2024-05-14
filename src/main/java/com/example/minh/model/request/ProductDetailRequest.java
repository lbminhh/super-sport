package com.example.minh.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailRequest {

    @NotNull(message = "price cannot be null")
    @Min(value = 1, message = "price must be greater than 1")
    BigDecimal price;

    @NotNull(message = "status cannot be null")
    Integer status;

    @NotNull(message = "price cannot be null")
    @Min(value = 0, message = "quantity must be greater than 0")
    Integer quantity;

    String description;

    @NotNull(message = "size cannot be null")
    Long sizeID;

    @NotNull(message = "color cannot be null")
    Long colorID;

    @NotNull(message = "product cannot be null")
    UUID productID;

}
