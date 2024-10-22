package com.example.Uber.service;

import com.example.Uber.dto.request.SaveRiderDto;
import com.example.Uber.dto.response.RiderDto;

import java.util.List;

public interface RiderService {

    RiderDto save(SaveRiderDto saveRiderDto);

    List<RiderDto> getAllRiders(Integer offset, Integer pageSize);

}
