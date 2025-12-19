package com.imanolortiz.ride.rides.domain.repository;

import com.imanolortiz.ride.rides.domain.model.Ride;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface RideRepository {
    Page<Ride> findUserRides();
    Ride save(Ride ride);
    Optional<Ride> findById(Long id);
}
