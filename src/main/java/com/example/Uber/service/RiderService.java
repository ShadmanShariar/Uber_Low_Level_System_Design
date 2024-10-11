package com.example.Uber.service;

import com.example.Uber.dto.request.SaveRiderDto;
import com.example.Uber.dto.response.RiderDto;

public interface RiderService {

    RiderDto save(SaveRiderDto saveRiderDto);

}
