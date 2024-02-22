package com.otpexample.service;

import com.otpexample.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.sax.SAXResult;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailVerificationService {

    @Autowired
    private UserService userService;

    static final Map<String ,String> emailOtpMapping =new HashMap<>();

    public Map<String,String> verifyOtp(String email, String otp){
        String storedOtp= emailOtpMapping.get(email);
        Map<String,String> response =new HashMap<>();
        if(storedOtp !=null && storedOtp.equals(otp)){
            User user=userService.getUserByEmail(email);
            if(user !=null){
                emailOtpMapping.remove(email);
                userService.verifyEmail(user);
                response.put("status","success");
                response.put("mesage","Email verified successfully");

            }else{
                //logger.error("Invalid OTP recived for email:{}",email);
                response.put("status","error");
                response.put("message","User not found");
            }
        }else{
            response.put("status","error");
            response.put("message","Invalid OTP");
        }
        return response;
    }
}
