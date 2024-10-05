package com.example.Uber.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveUserDto {

    private String image;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

}
