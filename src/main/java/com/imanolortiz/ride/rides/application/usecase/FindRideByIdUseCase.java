package com.imanolortiz.ride.rides.application.usecase;

import com.imanolortiz.ride.rides.domain.model.Ride;
import com.imanolortiz.ride.rides.domain.repository.RideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class FindRideByIdUseCase {

    private final RideRepository rideRepository;

    public Ride execute(Long id) {
        return rideRepository.findById(id).orElseThrow(() -> new RuntimeException("Ride not found"));
    }

}
