package com.example.minh.service.impl;

import com.example.minh.entity.Size;
import com.example.minh.exception.AppException;
import com.example.minh.model.enums.ErrorCode;
import com.example.minh.model.request.SizeRequest;
import com.example.minh.repository.SizeRepository;
import com.example.minh.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    SizeRepository sizeRepository;

    @Override
    public List<Size> getAllSizes() {
        return sizeRepository.findAll();
    }

    @Override
    public Size addSize(SizeRequest sizeRequest) {
        Size size = Size.builder()
                .sizeName(sizeRequest.getSizeName())
                .description(sizeRequest.getDescription())
                .build();
        return sizeRepository.save(size);
    }

    @Override
    public Size updateSize(SizeRequest sizeRequest, Long id) {
        Size size = sizeRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.SIZE_NOT_EXIST));

        size.setSizeName(sizeRequest.getSizeName());
        size.setDescription(sizeRequest.getDescription());
        return sizeRepository.save(size);
    }
}
