package com.codeup.springbootblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestHome {

    @GetMapping("/home")
    public String welcome() {
        return "home";
    }
}
