package com.imanolortiz.ride.rides.application.usecase;

import com.imanolortiz.ride.rides.domain.model.Ride;
import com.imanolortiz.ride.rides.domain.repository.RideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FindUserRidesUseCase {

    private final RideRepository rideRepository;

    public Page<Ride> execute() {
        return rideRepository.findUserRides();
    }

}
