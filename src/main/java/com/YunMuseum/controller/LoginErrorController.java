package com.YunMuseum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginErrorController {
    @RequestMapping("/LoginError")
    public String loginError(){
        return "LoginError";
    }
}
