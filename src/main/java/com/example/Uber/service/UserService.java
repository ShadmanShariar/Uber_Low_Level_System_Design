package com.example.Uber.service;

import com.example.Uber.dto.api.ApiResponse;
import com.example.Uber.dto.request.SaveUserDto;
import com.example.Uber.dto.response.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(SaveUserDto saveUserDto);

    ApiResponse<List<UserDto>> getAllUsers(Integer offset, Integer pageSize);

}
