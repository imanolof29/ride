package com.imanolortiz.ride.rides.infrastructure.db.adapter;

import com.imanolortiz.ride.rides.domain.model.Ride;
import com.imanolortiz.ride.rides.domain.repository.RideRepository;
import com.imanolortiz.ride.rides.infrastructure.db.entity.RideEntity;
import com.imanolortiz.ride.rides.infrastructure.db.mapper.RideEntityMapper;
import com.imanolortiz.ride.rides.infrastructure.db.repository.RideJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class RideRepositoryAdapter implements RideRepository {

    private final RideJpaRepository rideJpaRepository;

    @Override
    public Page<Ride> findUserRides() {
        Pageable pageable = Pageable.ofSize(10);
        return rideJpaRepository.findByPassengerId(1L, pageable)
                .map(RideEntityMapper::toDomain);
    }

    @Override
    public Ride save(Ride ride) {
        RideEntity newRide = RideEntityMapper.toEntity(ride);
        RideEntity savedRide = rideJpaRepository.save(newRide);
        return RideEntityMapper.toDomain(savedRide);
    }


    @Override
    public Optional<Ride> findById(Long id) {
        return rideJpaRepository.findById(id)
                .map(RideEntityMapper::toDomain);
    }
}
