package com.example.minh.controller;

import com.example.minh.entity.Color;
import com.example.minh.model.request.ColorRequest;
import com.example.minh.model.response.ApiResponse;
import com.example.minh.service.ColorService;
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
@RequestMapping("/api/color")
public class ColorController {

    @Autowired
    ColorService colorService;

    @PostMapping("/add")
    public ApiResponse<Color> addColor(@RequestBody @Valid ColorRequest colorRequest) {
        System.out.println(colorRequest);
        ApiResponse<Color> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("add color succesfully!");
        apiResponse.setResult(colorService.addColor(colorRequest));
        return apiResponse;
    }

    @PutMapping("/update/{id}")
    public ApiResponse<Color> update(@RequestBody @Valid ColorRequest colorRequest, @PathVariable Long id) {
        System.out.println(colorRequest);
        ApiResponse<Color> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("update color succesfully!");
        apiResponse.setResult(colorService.updateColor(colorRequest, id));
        return apiResponse;
    }

    @GetMapping("/list")
    public ApiResponse<List<Color>> getAllColors() {
        ApiResponse<List<Color>> apiResponse = new ApiResponse<>();
        apiResponse.setCode(1000);
        apiResponse.setMessage("get all color!");
        apiResponse.setResult(colorService.getAllColors());
        return apiResponse;
    }


}
