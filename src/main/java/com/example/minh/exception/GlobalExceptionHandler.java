package com.example.minh.exception;

import com.example.minh.model.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingRuntimeException(RuntimeException exception) {
        ApiResponse apiResponse = ApiResponse.builder()
                .code(999)
                .message(exception.getMessage())
                .build();
        return ResponseEntity.badRequest().body(ApiResponse.builder()
                .code(999)
                .message(exception.getMessage())
                .build()
        );
    }
}
