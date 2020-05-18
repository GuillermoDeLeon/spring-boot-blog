package com.codeup.springbootblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String goToLandingPage() {
        return "home";
    }

    @GetMapping("/home")
    public String goHome() {
        return "home";
    }
}