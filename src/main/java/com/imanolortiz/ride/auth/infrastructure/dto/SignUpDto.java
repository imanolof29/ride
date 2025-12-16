package com.imanolortiz.ride.auth.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SignUpDto {
    private String fullName;
    private String email;
    private String password;
}
