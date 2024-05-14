package com.example.minh.service.impl;

import com.example.minh.entity.ObjectUse;
import com.example.minh.exception.AppException;
import com.example.minh.model.enums.ErrorCode;
import com.example.minh.model.request.ObjectUseRequest;
import com.example.minh.repository.ObjectUseRepository;
import com.example.minh.service.ObjectUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectUseServiceImpl implements ObjectUseService {

    @Autowired
    ObjectUseRepository objectUseRepository;

    @Override
    public List<ObjectUse> getAllObjectUses() {
        return objectUseRepository.findAll();
    }

    @Override
    public ObjectUse addObjectUse(ObjectUseRequest objectUseRequest) {
        ObjectUse objectUse = ObjectUse.builder()
                .objectUseName(objectUseRequest.getObjectUseName())
                .description(objectUseRequest.getDescription())
                .build();
        return objectUseRepository.save(objectUse);
    }

    @Override
    public ObjectUse updateObjectUse(ObjectUseRequest objectUseRequest, Long id) {

        ObjectUse objectUse = objectUseRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.OBJECT_USE_NOT_EXIST));

        objectUse.setObjectUseName(objectUseRequest.getObjectUseName());
        objectUse.setDescription(objectUseRequest.getDescription());

        return objectUseRepository.save(objectUse);
    }
}
