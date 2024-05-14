package com.example.minh.controller;

import com.example.minh.entity.ObjectUse;
import com.example.minh.model.request.ObjectUseRequest;
import com.example.minh.model.response.ApiResponse;
import com.example.minh.service.ObjectUseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/object-use")
public class ObjectUseController {

    @Autowired
    ObjectUseService objectUseService;

    @PostMapping("/add")
    public ApiResponse<ObjectUse> addObjectUse(@RequestBody @Valid ObjectUseRequest objectUseRequest) {
        ApiResponse<ObjectUse> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("add object-use succesfully!");
        apiResponse.setResult(objectUseService.addObjectUse(objectUseRequest));
        return apiResponse;
    }

    @PutMapping("/update/{id}")
    public ApiResponse<ObjectUse> updateObjectUse(@RequestBody @Valid ObjectUseRequest objectUseRequest, @PathVariable Long id) {
        ApiResponse<ObjectUse> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("update object-use successfully!");
        apiResponse.setResult(objectUseService.updateObjectUse(objectUseRequest, id));
        return apiResponse;
    }

    @GetMapping("/list")
    public ApiResponse<List<ObjectUse>> getAllCategories() {
        ApiResponse<List<ObjectUse>> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("get all category!");
        apiResponse.setResult(objectUseService.getAllObjectUses());
        return apiResponse;
    }
}
