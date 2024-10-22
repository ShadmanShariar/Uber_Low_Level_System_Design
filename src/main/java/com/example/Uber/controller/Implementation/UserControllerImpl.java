package com.example.Uber.controller.Implementation;

import com.example.Uber.controller.UserController;
import com.example.Uber.dto.request.SaveUserDto;
import com.example.Uber.dto.response.UserDto;
import com.example.Uber.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Override
    public ResponseEntity<List<UserDto>> getAllUsers(@RequestParam(value = "offset", defaultValue = "0", required = false) Integer offset, @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize) {
        List<UserDto> users = userService.getAllUsers(offset, pageSize);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
