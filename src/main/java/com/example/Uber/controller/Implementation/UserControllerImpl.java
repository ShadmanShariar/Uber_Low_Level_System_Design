package com.example.Uber.controller.Implementation;

import com.example.Uber.controller.UserController;
import com.example.Uber.dto.request.SaveUserDto;
import com.example.Uber.dto.response.UserDto;
import com.example.Uber.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserDto> createUser(@RequestBody SaveUserDto saveUserDto) {
        UserDto savedUser = userService.save(saveUserDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

}
