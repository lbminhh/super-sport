package com.example.minh.service;

import com.example.minh.entity.Color;
import com.example.minh.model.request.ColorRequest;

import java.util.List;

public interface ColorService {

    List<Color> getAllColors();

    Color addColor(ColorRequest colorRequest);

    Color updateColor(ColorRequest colorRequest, Long id);
}
