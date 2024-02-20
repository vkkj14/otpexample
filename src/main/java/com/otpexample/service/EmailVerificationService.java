package com.otpexample.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailVerificationService {

    static final Map<String ,String> emailOtpMapping =new HashMap<>();
}
