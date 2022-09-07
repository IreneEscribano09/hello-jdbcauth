package com.sinensia.demo.jdbcauth;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "Hello, world!";
    }

    @GetMapping("/user")
    public String helloUser() {
        return "Hello, user!";
    }

    @GetMapping("/admin")
    public String helloAdmin() {
        return "Hello, admin!";
    }

    @GetMapping("/hello")
    public String helloAnyone(@AuthenticationPrincipal UserDetails user) {
        if (user != null) {
            return "Hello, " + user.toString();
        } else {
            return "Who are you?";
        }
    }
}
