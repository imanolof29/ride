package com.imanolortiz.ride.users.infrastructure.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {
    public Long id;
    public String email;
    public String fullName;
}
