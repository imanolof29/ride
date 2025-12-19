package com.imanolortiz.ride.rides.infrastructure.rest.dto;

import com.imanolortiz.ride.users.infrastructure.rest.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class RideDto {
    private Long id;
    private UserDto user;
    private LocationDto passengerLocation;
    private LocationDto destinationLocation;
}
