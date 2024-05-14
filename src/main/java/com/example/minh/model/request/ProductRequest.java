package com.example.minh.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NotEmpty(message = "product name can not empty!")
    String productName;

    Integer status;

    String description;

    @NotNull(message = "brand cannot be null")
    Long brandID;

    @NotNull(message = "sub-category cannot be null")
    Long subCategoryID;

    @NotNull(message = "object-use cannot be null")
    Set<String> objectUses;

    @NotNull(message = "color cannot be null")
    Set<String> colors;



}
