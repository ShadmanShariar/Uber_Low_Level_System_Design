package com.example.Uber.controller.Implementation;

import com.example.Uber.controller.RiderController;
import com.example.Uber.dto.request.SaveRiderDto;
import com.example.Uber.dto.response.RiderDto;
import com.example.Uber.service.RiderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiderControllerImpl implements RiderController {

    private final RiderService riderService;

    public RiderControllerImpl(RiderService riderService) {
        this.riderService = riderService;
    }

    @Override
    public ResponseEntity<RiderDto> createRider(@RequestBody SaveRiderDto saveRiderDto) {
        RiderDto savedRider = riderService.save(saveRiderDto);
        return new ResponseEntity<>(savedRider, HttpStatus.CREATED);
    }

}
