package com.example.minh.controller;

import com.example.minh.entity.Size;
import com.example.minh.model.request.SizeRequest;
import com.example.minh.model.response.ApiResponse;
import com.example.minh.service.SizeService;
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
@RequestMapping("/api/size")
public class SizeController {

    @Autowired
    SizeService sizeService;

    @PostMapping("/add")
    public ApiResponse<Size> addSize(@RequestBody @Valid SizeRequest sizeRequest) {
        ApiResponse<Size> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("add size succesfully!");
        apiResponse.setResult(sizeService.addSize(sizeRequest));
        return apiResponse;
    }

    @PutMapping("/update/{id}")
    public ApiResponse<Size> updateSize(@RequestBody @Valid SizeRequest sizeRequest, @PathVariable Long id) {
        ApiResponse<Size> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("update size succesfully!");
        apiResponse.setResult(sizeService.updateSize(sizeRequest, id));
        return apiResponse;
    }

    @GetMapping("/list")
    public ApiResponse<List<Size>> getAllSizes() {
        ApiResponse<List<Size>> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("get size color!");
        apiResponse.setResult(sizeService.getAllSizes());
        return apiResponse;
    }


}
