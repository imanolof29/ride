package com.imanolortiz.ride.auth.application.usecase;

import com.imanolortiz.ride.auth.domain.model.AuthToken;
import com.imanolortiz.ride.auth.infrastructure.dto.SignUpDto;
import com.imanolortiz.ride.config.JwtTokenProvider;
import com.imanolortiz.ride.users.domain.model.User;
import com.imanolortiz.ride.users.domain.repository.UserRepository;
import com.imanolortiz.ride.users.infrastructure.rest.mapper.UserDtoMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SignUpUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public AuthToken execute(SignUpDto dto) {
        if (userRepository.emailExists(dto.getEmail())) {
            throw new RuntimeException("Email already in use");
        }
        String hashedPassword = passwordEncoder.encode(dto.getPassword());
        User user = userRepository.save(UserDtoMapper.toDomain(dto, hashedPassword));
        return jwtTokenProvider.generateJWT(user.getId(), user.getEmail());
    }

}
