package com.imanolortiz.ride.rides.application.usecase;

import com.imanolortiz.ride.rides.domain.model.Ride;
import com.imanolortiz.ride.rides.domain.repository.RideRepository;
import com.imanolortiz.ride.rides.infrastructure.rest.dto.RequestRideDto;
import com.imanolortiz.ride.rides.infrastructure.rest.mapper.RideDtoMapper;
import com.imanolortiz.ride.users.domain.model.User;
import com.imanolortiz.ride.users.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RequestRideUseCase {

    private final RideRepository rideRepository;
    private final UserRepository userRepository;

    public Ride execute(RequestRideDto dto) {
        User user = userRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return rideRepository.save(RideDtoMapper.toDomain(dto, user));
    }

}
