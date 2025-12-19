package com.imanolortiz.ride.rides.domain.model;

import com.imanolortiz.ride.users.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@AllArgsConstructor
@Builder
public class Ride {
    private Long id;
    private User passenger;
    private Location passengerLocation;
    private Location destinationLocation;
    private Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;
}
