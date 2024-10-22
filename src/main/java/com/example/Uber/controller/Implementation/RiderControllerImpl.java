package com.example.Uber.controller.Implementation;

import com.example.Uber.controller.RiderController;
import com.example.Uber.dto.request.SaveRiderDto;
import com.example.Uber.dto.response.RiderDto;
import com.example.Uber.service.RiderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Override
    public ResponseEntity<List<RiderDto>> getAllRiders(@RequestParam(value = "offset", defaultValue = "0", required = false) Integer offset, @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize) {
        List<RiderDto> riders = riderService.getAllRiders(offset, pageSize);
        return new ResponseEntity<>(riders, HttpStatus.OK);
    }

}
