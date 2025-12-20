package com.imanolortiz.ride.notifications.infrastructure.rest.mapper;

import com.imanolortiz.ride.notifications.domain.model.DeviceToken;
import com.imanolortiz.ride.notifications.infrastructure.rest.dto.DeviceTokenDto;
import com.imanolortiz.ride.notifications.infrastructure.rest.dto.RegisterDeviceTokenDto;
import com.imanolortiz.ride.users.domain.model.User;

import java.time.Instant;

public class DeviceTokenDtoMapper {

    public static DeviceToken toDomain(RegisterDeviceTokenDto dto, User user) {
        Instant now = Instant.now();
        return DeviceToken.builder()
                .deviceToken(dto.getDeviceToken())
                .user(user)
                .createdAt(now)
                .updatedAt(now)
                .deletedAt(null)
                .build();
    }

    public static DeviceTokenDto toDto(DeviceToken model) {
        if (model == null) return null;
        return new DeviceTokenDto(model.getDeviceToken(), model.getUser() != null ? model.getUser().getId() : null);
    }

}
