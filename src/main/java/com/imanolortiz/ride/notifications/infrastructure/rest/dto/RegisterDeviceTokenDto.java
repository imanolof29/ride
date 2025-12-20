package com.imanolortiz.ride.notifications.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegisterDeviceTokenDto {
    private final String deviceToken;
}
