package com.example.minh.mapper;

import com.example.minh.entity.Color;
import com.example.minh.model.request.ColorRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ColorMapper {

    Color toColor(ColorRequest colorRequest);

}
