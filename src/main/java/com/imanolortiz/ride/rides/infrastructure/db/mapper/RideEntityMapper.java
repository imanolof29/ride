package com.imanolortiz.ride.rides.infrastructure.db.mapper;

import com.imanolortiz.ride.rides.domain.model.Ride;
import com.imanolortiz.ride.rides.infrastructure.db.entity.RideEntity;
import com.imanolortiz.ride.users.infrastructure.db.mapper.UserEntityMapper;

import java.time.Instant;

public class RideEntityMapper {

    public static Ride toDomain(RideEntity entity) {
        return Ride
                .builder()
                .id(entity.getId())
                .passenger(UserEntityMapper.toDomain(entity.getPassenger()))
                .passengerLocation(LocationEntityMapper.toDomain(entity.getPassengerLocation()))
                .destinationLocation(LocationEntityMapper.toDomain(entity.getDestinationLocation()))
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .deletedAt(entity.getDeletedAt())
                .build();
    }

    public static RideEntity toEntity(Ride model) {
        Instant now = Instant.now();
        return RideEntity
                .builder()
                .passenger(UserEntityMapper.toEntity(model.getPassenger()))
                .passengerLocation(LocationEntityMapper.toEntity(model.getPassengerLocation()))
                .destinationLocation(LocationEntityMapper.toEntity(model.getDestinationLocation()))
                .createdAt(now)
                .updatedAt(now)
                .deletedAt(null)
                .build();
    }

}
