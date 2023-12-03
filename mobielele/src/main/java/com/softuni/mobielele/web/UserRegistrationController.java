package com.softuni.mobielele.web;

import com.softuni.mobielele.model.dto.UserRegistrationDTO;
import com.softuni.mobielele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
public class UserRegistrationController {
    private final UserService userService;

    public UserRegistrationController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(){
        return "auth-register";
    }
    @PostMapping("/register")
    public String register(UserRegistrationDTO userRegistrationDto){

        userService.registerUser(userRegistrationDto);

        return "redirect:/";
    }
}
