package com.example.MediCare.mapper;

import com.example.MediCare.model.User;
import com.example.MediCare.payload.dto.UserDto;

public class UserMapper {

    public static UserDto toDTO(User savedUser){
        if(savedUser == null) return null;
        UserDto userDto = new UserDto();
        userDto.setId(savedUser.getId());
        userDto.setFullName(savedUser.getFullName());
        userDto.setEmail(savedUser.getEmail());
        userDto.setPassword(savedUser.getPassword());
        userDto.setImage(savedUser.getImage());
        userDto.setRole(savedUser.getRole());
        userDto.setCreatedAt(savedUser.getCreatedAt());
        userDto.setUpdatedAt(savedUser.getUpdatedAt());
        userDto.setLastLogin(savedUser.getLastLogin());
        return userDto;
    }

    public static  User toEntity(UserDto userDto){
        if(userDto == null) return  null;
        User createdUser = new User();
        createdUser.setFullName(userDto.getFullName());
        createdUser.setEmail(userDto.getEmail());
        createdUser.setPassword(userDto.getPassword());
        createdUser.setRole(userDto.getRole());
        createdUser.setCreatedAt(userDto.getCreatedAt());
        createdUser.setUpdatedAt(userDto.getUpdatedAt());
        createdUser.setLastLogin(userDto.getLastLogin());
        createdUser.setPassword(userDto.getPassword());
        return createdUser;
    }
}
