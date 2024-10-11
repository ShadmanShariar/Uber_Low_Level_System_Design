package com.example.Uber.controller;

import com.example.Uber.dto.request.SaveRiderDto;
import com.example.Uber.dto.response.RiderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.example.Uber.constant.WebApiUrlConstants.RIDER_API;

@RequestMapping(value = RIDER_API, produces = "application/json")
public interface RiderController {

    @PostMapping
    ResponseEntity<RiderDto> createRider(SaveRiderDto saveRiderDto);

}
