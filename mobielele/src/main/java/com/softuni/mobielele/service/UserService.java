package com.softuni.mobielele.service;

import com.softuni.mobielele.model.dto.UserLoginDto;
import com.softuni.mobielele.model.dto.UserRegistrationDTO;

public interface UserService {
    void registerUser(UserRegistrationDTO userRegistrationDto);

    boolean loginUser(UserLoginDto userLoginDto);

    void logoutUser();
}
