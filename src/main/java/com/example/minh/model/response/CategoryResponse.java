package com.example.minh.model.response;

import com.example.minh.entity.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CategoryResponse {

    private Long id;

    private String categoryName;

    private String description;

    private List<String> subCategoryNames;

}
