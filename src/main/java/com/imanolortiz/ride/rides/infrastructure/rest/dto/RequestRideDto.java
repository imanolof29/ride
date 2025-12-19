package com.imanolortiz.ride.rides.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RequestRideDto {
    private final LocationDto passengerLocation;
    private final LocationDto destinationLocation;
}
