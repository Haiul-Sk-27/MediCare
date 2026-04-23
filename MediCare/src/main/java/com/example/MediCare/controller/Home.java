package com.example.MediCare.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @GetMapping("/")
    public String home(){
        return "Welcome to the MediCare Application.....";
    }
}
