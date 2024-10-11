package com.example.Uber.service.Implementation;

import com.example.Uber.dto.request.SaveRiderDto;
import com.example.Uber.dto.response.RiderDto;
import com.example.Uber.model.Rider;
import com.example.Uber.repository.RiderRepository;
import com.example.Uber.service.RiderService;
import org.springframework.stereotype.Service;

@Service
public class RiderServiceImpl implements RiderService {

    private final RiderRepository riderRepository;

    public RiderServiceImpl(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    @Override
    public RiderDto save(SaveRiderDto saveRiderDto) {
        Rider rider = riderRepository.save(Rider.toRider(saveRiderDto));
        return Rider.toRiderDto(rider);
    }

}
