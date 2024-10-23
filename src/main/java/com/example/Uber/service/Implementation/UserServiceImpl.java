package com.example.Uber.service.Implementation;

import com.example.Uber.dto.api.ApiResponse;
import com.example.Uber.dto.request.SaveUserDto;
import com.example.Uber.dto.response.RiderDto;
import com.example.Uber.dto.response.UserDto;
import com.example.Uber.model.User;
import com.example.Uber.repository.UserRepository;
import com.example.Uber.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public ApiResponse<List<UserDto>> getAllUsers(Integer offset, Integer pageSize) {
        Pageable pageable = PageRequest.of(offset, pageSize);
        Page<User> pageUser = userRepository.findAll(pageable);
        List<User> allUser = pageUser.getContent();
        List<UserDto> userDtos = allUser.stream().map(user -> user.toUserDto(user)).collect(Collectors.toList());
        return new ApiResponse<>("Data fetched successfully", HttpStatus.OK.value(), userDtos);
    }

}
