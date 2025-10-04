package com.saurav.SpringJWTAuthenticationDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestToken {

    @GetMapping("/test")
    public String testToken(){

        return "Token is correct !! You are now accessing the protected routes!!";

    }

}
