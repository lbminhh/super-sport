package com.example.minh.service;

import com.example.minh.entity.Color;
import com.example.minh.entity.ObjectUse;
import com.example.minh.model.request.ColorRequest;
import com.example.minh.model.request.ObjectUseRequest;

import java.util.List;

public interface ObjectUseService {

    List<ObjectUse> getAllObjectUses();

    ObjectUse addObjectUse(ObjectUseRequest objectUseRequest);

    ObjectUse updateObjectUse(ObjectUseRequest objectUseRequest, Long id);
}
