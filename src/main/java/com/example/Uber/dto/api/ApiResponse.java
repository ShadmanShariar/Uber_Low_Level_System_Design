package com.example.Uber.dto.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
    private String message;
    private int statusCode;
    private T data;
}


