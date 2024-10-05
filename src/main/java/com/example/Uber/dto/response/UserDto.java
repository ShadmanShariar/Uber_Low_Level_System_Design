package com.example.Uber.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserDto {

    private UUID id;
    private String image;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

}
