package com.imanolortiz.ride.auth.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SignInDto {
    private String email;
    private String password;
}
