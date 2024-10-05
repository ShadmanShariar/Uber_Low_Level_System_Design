package com.example.Uber.model;

import com.example.Uber.dto.request.SaveUserDto;
import com.example.Uber.dto.response.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private UUID id;
    private String image;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public static UserDto toUserDto(User user) {
        return UserDto.builder().
                id(user.getId()).
                image(user.getImage()).
                firstName(user.getFirstName()).
                lastName(user.getLastName()).
                phoneNumber(user.getPhoneNumber()).
                email(user.getEmail()).
                build();
    }

    public static User toUser(SaveUserDto user) {
        return User.builder().
                id(UUID.randomUUID()).
                image(user.getImage()).
                firstName(user.getFirstName()).
                lastName(user.getLastName()).
                phoneNumber(user.getPhoneNumber()).
                email(user.getEmail()).
                build();
    }

}
