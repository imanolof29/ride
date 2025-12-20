package com.imanolortiz.ride.notifications.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DeviceTokenDto {
    private final String deviceToken;
    private final Long userId;
}
