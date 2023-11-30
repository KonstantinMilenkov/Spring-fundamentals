package com.softuni.mobielele.service;

import com.softuni.mobielele.model.dto.UserLoginDto;
import com.softuni.mobielele.model.dto.UserRegistrationDto;

public interface UserService {
    void registerUser(UserRegistrationDto userRegistrationDto);

    boolean loginUser(UserLoginDto userLoginDto);

    void logoutUser();
}
