package com.example.Uber.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RiderDto {

    private UUID id;
    private String image;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

}
