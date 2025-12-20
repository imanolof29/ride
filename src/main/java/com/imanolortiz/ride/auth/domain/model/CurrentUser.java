package com.imanolortiz.ride.auth.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CurrentUser {
    private Long id;
    private String email;
}
