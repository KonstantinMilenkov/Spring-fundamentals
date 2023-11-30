package com.softuni.mobielele.web;

import com.softuni.mobielele.model.dto.UserLoginDto;
import com.softuni.mobielele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserLoginController {
    private final UserService userService;
    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login(){
        return "auth-login";
    }
    @GetMapping("/users/logout")
    public String logout(){

        userService.logoutUser();
        return "index";
    }

    @PostMapping("/users/login")
    public String login(UserLoginDto userLoginDto){
        boolean loginSuccessful = userService.loginUser(userLoginDto);

        return loginSuccessful ? "index" : "auth-login";
    }

}
