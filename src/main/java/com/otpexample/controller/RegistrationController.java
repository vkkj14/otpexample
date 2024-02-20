package com.otpexample.controller;


import com.otpexample.entity.User;
import com.otpexample.service.EmailService;
import com.otpexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/register")
    public Map<String ,String> registerUser(@RequestBody User user){
        //Register the user without email verification
        User registeredUser =userService.registerUser(user);

        //send OTP email for email verification

        emailService.sendOtpEmail(user.getEmail());
        return null;
    }
}
