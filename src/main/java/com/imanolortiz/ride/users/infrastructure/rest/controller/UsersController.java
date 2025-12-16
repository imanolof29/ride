package com.imanolortiz.ride.users.infrastructure.rest.controller;

import com.imanolortiz.ride.users.application.usecase.FindUserByEmail;
import com.imanolortiz.ride.users.domain.model.User;
import com.imanolortiz.ride.users.infrastructure.rest.dto.UserDto;
import com.imanolortiz.ride.users.infrastructure.rest.mapper.UserDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {

    private final FindUserByEmail findUserByEmail;

    @GetMapping("/{email}")
    public ResponseEntity<UserDto> findUserByEmail(@PathVariable String email) {
        User user = findUserByEmail.execute(email);
        return ResponseEntity.ok(UserDtoMapper.toDto(user));
    }

}
