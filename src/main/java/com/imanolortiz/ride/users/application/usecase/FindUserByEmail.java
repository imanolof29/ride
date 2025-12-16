package com.imanolortiz.ride.users.application.usecase;

import com.imanolortiz.ride.users.domain.model.User;
import com.imanolortiz.ride.users.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FindUserByEmail {

    private final UserRepository userRepository;

    public User execute(String email) {
        return userRepository.findByEmail(email);
    }

}
