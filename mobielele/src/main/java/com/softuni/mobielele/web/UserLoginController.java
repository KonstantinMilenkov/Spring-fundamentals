package com.softuni.mobielele.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserLoginController {
    @GetMapping("/users/login")
    public String login(){
        return "auth-login";
    }

}
