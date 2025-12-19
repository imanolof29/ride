package com.imanolortiz.ride.auth.infrastructure.rest.mapper;

import com.imanolortiz.ride.auth.domain.model.AuthToken;
import com.imanolortiz.ride.auth.infrastructure.dto.AuthResponseDto;

public class AuthDtoMapper {

    public static AuthResponseDto toDto(AuthToken authToken) {
        return AuthResponseDto
                .builder()
                .accessToken(authToken.getToken())
                .refreshToken(authToken.getRefreshToken())
                .build();
    }

}
