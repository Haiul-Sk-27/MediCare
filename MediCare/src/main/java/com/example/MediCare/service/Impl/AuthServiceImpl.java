package com.example.MediCare.service.Impl;

import com.example.MediCare.config.JwtProvider;
import com.example.MediCare.exceptions.UserExceptions;
import com.example.MediCare.mapper.UserMapper;
import com.example.MediCare.model.User;
import com.example.MediCare.payload.dto.UserDto;
import com.example.MediCare.payload.response.AuthResponse;
import com.example.MediCare.repository.UserRepository;
import com.example.MediCare.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    @Override
    public AuthResponse login(UserDto userDto) throws UserExceptions {
        User user = userRepository.findByEmail(userDto.getEmail())
                .orElseThrow(() -> new UserExceptions("User not found"));

        if (!passwordEncoder.matches(userDto.getPassword(),user.getPassword())){
            throw new UserExceptions("Invalid password");
        }

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                null,
                AuthorityUtils.createAuthorityList("ROLE_" + user.getRole().name())
        );

        String jwt = jwtProvider.generateToken(authentication);

        AuthResponse response = new AuthResponse();
        response.setMessage("Login successfull");
        response.setJwt(jwt);
        response.setUser(UserMapper.toDTO(user));
        return  response;
    }

    @Override
    public UserDto getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(()-> new UserExceptions("User not found"));

        return UserMapper.toDTO(user);
    }

    @Override
    public UserDto updateAdminInfo(UserDto userDto,Long id) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(()-> new UserExceptions("User not found"));

        existingUser.setAddress(userDto.getAddress());
        existingUser.setImage(userDto.getImage());
        existingUser.setUpdatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(existingUser);
        return UserMapper.toDTO(savedUser);
    }
}
