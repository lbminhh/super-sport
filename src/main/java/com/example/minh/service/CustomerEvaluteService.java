package com.example.minh.service;

import com.example.minh.entity.Evaluate;
import com.example.minh.model.request.EvaluateRequest;

public interface CustomerEvaluteService {

    Evaluate add(EvaluateRequest request);

    Evaluate update(EvaluateRequest request, Long id);

    Evaluate delete(Long id);

}
