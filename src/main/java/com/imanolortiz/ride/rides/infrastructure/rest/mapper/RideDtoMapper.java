package com.imanolortiz.ride.rides.infrastructure.rest.mapper;

import com.imanolortiz.ride.rides.domain.model.Ride;
import com.imanolortiz.ride.rides.infrastructure.rest.dto.RequestRideDto;
import com.imanolortiz.ride.rides.infrastructure.rest.dto.RideDto;
import com.imanolortiz.ride.users.domain.model.User;
import com.imanolortiz.ride.users.infrastructure.rest.mapper.UserDtoMapper;

import java.time.Instant;

public class RideDtoMapper {

    public static RideDto toDto(Ride ride) {
        return RideDto
                .builder()
                .id(ride.getId())
                .user(UserDtoMapper.toDto(ride.getPassenger()))
                .passengerLocation(LocationDtoMapper.toDto(ride.getPassengerLocation()))
                .destinationLocation(LocationDtoMapper.toDto(ride.getDestinationLocation()))
                .build();
    }

    public static Ride toDomain(RequestRideDto dto, User user) {
        Instant now = Instant.now();
        return Ride
                .builder()
                .passenger(user)
                .passengerLocation(LocationDtoMapper.toDomain(dto.getPassengerLocation()))
                .destinationLocation(LocationDtoMapper.toDomain(dto.getDestinationLocation()))
                .createdAt(now)
                .updatedAt(now)
                .deletedAt(null)
                .build();
    }

}
