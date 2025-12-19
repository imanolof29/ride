package com.imanolortiz.ride.rides.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Location {
    private final double latitude;
    private final double longitude;
}
