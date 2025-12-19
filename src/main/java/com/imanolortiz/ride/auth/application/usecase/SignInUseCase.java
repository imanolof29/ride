package com.imanolortiz.ride.auth.application.usecase;

import com.imanolortiz.ride.auth.domain.model.AuthToken;
import com.imanolortiz.ride.auth.infrastructure.dto.SignInDto;
import com.imanolortiz.ride.config.JwtTokenProvider;
import com.imanolortiz.ride.users.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SignInUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthToken execute(SignInDto dto) {
        return userRepository.findByEmail(dto.getEmail())
                .map(user -> {
                   if(!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
                       throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid credentials");
                   }
                    return jwtTokenProvider.generateJWT(user.getId(), user.getEmail());

                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid credentials"));
     }

 }
