package com.imanolortiz.ride.auth.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class AuthResponseDto {
    private String accessToken;
    private String refreshToken;
}
