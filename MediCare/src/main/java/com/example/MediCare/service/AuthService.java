package com.example.MediCare.service;

import com.example.MediCare.exceptions.UserExceptions;
import com.example.MediCare.payload.dto.UserDto;
import com.example.MediCare.payload.response.AuthResponse;

public interface AuthService {
    AuthResponse login(UserDto userDto) throws UserExceptions;
    UserDto getUserById(Long id);
    UserDto updateAdminInfo(UserDto userDto,Long id);
}

