package com.imanolortiz.ride.rides.infrastructure.rest.mapper;

import com.imanolortiz.ride.rides.domain.model.Location;
import com.imanolortiz.ride.rides.infrastructure.rest.dto.LocationDto;

public class LocationDtoMapper {

    public static LocationDto toDto(Location location) {
        return new LocationDto(location.getLatitude(), location.getLongitude());
    }

    public static Location toDomain(LocationDto dto) {
        return new Location(dto.latitude(), dto.longitude());
    }

}
