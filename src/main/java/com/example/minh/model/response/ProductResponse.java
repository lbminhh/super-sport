package com.example.minh.model.response;

import com.example.minh.entity.Color;
import com.example.minh.entity.ObjectUse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {

    UUID id;

    String productName;

    String subCategoryName;

    String brandName;

    Integer status;

    List<String> colors;

    List<String> objectUses;

    String description;
}
