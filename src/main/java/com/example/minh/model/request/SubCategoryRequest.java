package com.example.minh.model.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubCategoryRequest {

    @NotEmpty(message = "category name can not empty.")
    private String subCategoryName;

    private String description;

    Long categoryID;

}
