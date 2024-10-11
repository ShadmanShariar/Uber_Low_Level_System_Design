package com.example.Uber.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveRiderDto {

    private String image;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

}
