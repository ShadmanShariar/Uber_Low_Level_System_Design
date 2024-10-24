package com.example.Uber.model;

import com.example.Uber.enums.PaymentMethod;
import com.example.Uber.enums.RideRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class RideRequest {

    @Id
    private UUID id;
    private Rider rider;
    private Point pickupLocation;
    private Point dropLocation;
    private LocalDateTime requestedTime;
    private RideRequestStatus status;
    private PaymentMethod paymentMethod;

}
