package com.softuni.mobielele.service.impl;

import com.softuni.mobielele.model.dto.UserLoginDto;
import com.softuni.mobielele.model.dto.UserRegistrationDTO;
import com.softuni.mobielele.model.entity.UserEntity;
import com.softuni.mobielele.repository.UserRepository;
import com.softuni.mobielele.service.UserService;
import com.softuni.mobielele.util.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDto) {
        userRepository.save(map(userRegistrationDto));
    }

    @Override
    public boolean loginUser(UserLoginDto userLoginDto) {
        var userEntity = userRepository.findByEmail(userLoginDto.email())
                .orElse(null);

        boolean loginSuccess = false;

        if (userEntity != null){

            String rawPassword = userLoginDto.password();
            String encodedPassword = userEntity.getPassword();

            loginSuccess = encodedPassword != null &&
                    passwordEncoder.matches(rawPassword, encodedPassword);
            if (loginSuccess) {
                currentUser.setLogged(true)
                        .setFirstName(userEntity.getFirstName())
                        .setLastName(userEntity.getLastName());
            }else {
                currentUser.logout();
            }
        }
        return loginSuccess;
    }

    @Override
    public void logoutUser() {
        currentUser.logout();
    }

    private UserEntity map(UserRegistrationDTO userRegistrationDTO) {
        return new UserEntity()
                .setActive(true)
                .setFirstName(userRegistrationDTO.firstName())
                .setLastName(userRegistrationDTO.lastName())
                .setEmail(userRegistrationDTO.email())
                .setPassword(passwordEncoder.encode(userRegistrationDTO.password()));
    }
}
