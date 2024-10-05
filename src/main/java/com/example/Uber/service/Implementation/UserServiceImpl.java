package com.example.Uber.service.Implementation;

import com.example.Uber.dto.request.SaveUserDto;
import com.example.Uber.dto.response.UserDto;
import com.example.Uber.model.User;
import com.example.Uber.repository.UserRepository;
import com.example.Uber.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(SaveUserDto saveUserDto) {
        User user = userRepository.save(User.toUser(saveUserDto));
        return User.toUserDto(user);
    }

}
