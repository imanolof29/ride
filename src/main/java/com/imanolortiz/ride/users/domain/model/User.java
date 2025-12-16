package com.imanolortiz.ride.users.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {
    private Long id;
    private String email;
    private String fullName;
}
