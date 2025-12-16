package com.imanolortiz.ride.users.infrastructure.rest.mapper;

import com.imanolortiz.ride.auth.infrastructure.dto.SignUpDto;
import com.imanolortiz.ride.users.domain.model.User;
import com.imanolortiz.ride.users.infrastructure.rest.dto.UserDto;

public class UserDtoMapper {

    public static UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getEmail(), user.getFullName());
    }

    public static User toDomain(SignUpDto dto, String hashedPassword) {
        return User
                .builder()
                .email(dto.getEmail())
                .fullName(dto.getFullName())
                .password(hashedPassword)
                .build();
    }

}
