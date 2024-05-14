package com.example.minh.service.impl;

import com.example.minh.entity.Color;
import com.example.minh.exception.AppException;
import com.example.minh.mapper.ColorMapper;
import com.example.minh.model.enums.ErrorCode;
import com.example.minh.model.request.ColorRequest;
import com.example.minh.repository.ColorRepository;
import com.example.minh.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    ColorRepository colorRepository;

    @Autowired
    ColorMapper colorMapper;

    @Override
    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    @Override
    public Color addColor(ColorRequest colorRequest) {
        Color color = colorMapper.toColor(colorRequest);
        return colorRepository.save(color);
    }

    @Override
    public Color updateColor(ColorRequest colorRequest, Long id) {

        if (!colorRepository.existsById(id)) {
            throw new AppException(ErrorCode.COLOR_NOT_EXIST);
        }

        Color color = colorMapper.toColor(colorRequest);
        color.setId(id);
        return colorRepository.save(color);
    }


}
