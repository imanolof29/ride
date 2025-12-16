package com.imanolortiz.ride.auth.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthResponseDto {
    private String accessToken;
    private String refreshToken;
}
