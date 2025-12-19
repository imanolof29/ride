package com.imanolortiz.ride.auth.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

@AllArgsConstructor
@Getter
public class AuthToken {
    private final String token;
    private final String refreshToken;
    private final Long userId;
    private final Instant issuedAt;
    private final Instant expiresAt;
}
