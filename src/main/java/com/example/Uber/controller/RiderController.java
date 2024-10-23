package com.example.Uber.controller;

import com.example.Uber.dto.api.ApiResponse;
import com.example.Uber.dto.request.SaveRiderDto;
import com.example.Uber.dto.response.RiderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.example.Uber.constant.WebApiUrlConstants.RIDER_API;

@RequestMapping(value = RIDER_API, produces = "application/json")
public interface RiderController {

    @PostMapping
    ResponseEntity<RiderDto> createRider(SaveRiderDto saveRiderDto);

    @GetMapping
    ResponseEntity<ApiResponse<List<RiderDto>>> getAllRiders (@RequestParam(value = "offset", defaultValue = "0", required = false) Integer offset, @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize);

}
