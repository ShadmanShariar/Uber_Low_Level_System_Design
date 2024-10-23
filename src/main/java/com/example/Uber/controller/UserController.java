package com.example.Uber.controller;

import com.example.Uber.dto.api.ApiResponse;
import com.example.Uber.dto.request.SaveUserDto;
import com.example.Uber.dto.response.RiderDto;
import com.example.Uber.dto.response.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.example.Uber.constant.WebApiUrlConstants.CLIENT_API;

@RequestMapping(value = CLIENT_API, produces = "application/json")
public interface UserController {

    @PostMapping
    ResponseEntity<UserDto> createUser(SaveUserDto saveUserDto);

    @GetMapping
    ResponseEntity<ApiResponse<List<UserDto>>> getAllUsers (@RequestParam(value = "offset", defaultValue = "0", required = false) Integer offset, @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize);

}
