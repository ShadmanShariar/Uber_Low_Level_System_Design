package com.example.Uber.service;

import com.example.Uber.dto.request.SaveUserDto;
import com.example.Uber.dto.response.UserDto;

public interface UserService {

    UserDto save(SaveUserDto saveUserDto);

}
