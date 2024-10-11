package com.example.Uber.model;

import com.example.Uber.dto.request.SaveRiderDto;
import com.example.Uber.dto.response.RiderDto;
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
public class Rider {

    @Id
    private UUID id;
    private String image;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public static RiderDto toRiderDto(Rider rider) {
        return RiderDto.builder().
                id(rider.getId()).
                image(rider.getImage()).
                firstName(rider.getFirstName()).
                lastName(rider.getLastName()).
                phoneNumber(rider.getPhoneNumber()).
                email(rider.getEmail()).
                build();
    }

    public static Rider toRider(SaveRiderDto rider) {
        return Rider.builder().
                id(UUID.randomUUID()).
                image(rider.getImage()).
                firstName(rider.getFirstName()).
                lastName(rider.getLastName()).
                phoneNumber(rider.getPhoneNumber()).
                email(rider.getEmail()).
                build();
    }

}
