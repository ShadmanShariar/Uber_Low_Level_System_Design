package com.example.Uber.controller;

import com.example.Uber.dto.request.SaveUserDto;
import com.example.Uber.dto.response.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/user", produces = "application/json")
public interface UserController {

    @PostMapping
    ResponseEntity<UserDto> createUser(SaveUserDto saveUserDto);

}
