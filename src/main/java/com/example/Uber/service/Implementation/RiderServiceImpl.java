package com.example.Uber.service.Implementation;

import com.example.Uber.dto.api.ApiResponse;
import com.example.Uber.dto.request.SaveRiderDto;
import com.example.Uber.dto.response.RiderDto;
import com.example.Uber.model.Rider;
import com.example.Uber.repository.RiderRepository;
import com.example.Uber.service.RiderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class  RiderServiceImpl implements RiderService {

    private final RiderRepository riderRepository;

    public RiderServiceImpl(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    @Override
    public RiderDto save(SaveRiderDto saveRiderDto) {
        Rider rider = riderRepository.save(Rider.toRider(saveRiderDto));
        return Rider.toRiderDto(rider);
    }

    @Override
    public ApiResponse<List<RiderDto>> getAllRiders(Integer offset, Integer pageSize) {
        Pageable pageable = PageRequest.of(offset, pageSize);
        Page<Rider> pageRider = riderRepository.findAll(pageable);
        List<Rider> allRider = pageRider.getContent();
        List<RiderDto> riderDtos = allRider.stream().map(rider -> rider.toRiderDto(rider)).collect(Collectors.toList());
        return new ApiResponse<>("Data fetched successfully", HttpStatus.OK.value(), riderDtos);
    }

}
