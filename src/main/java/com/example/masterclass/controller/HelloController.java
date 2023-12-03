package com.example.masterclass.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
//    @Value("${hello.message}")
//    private String helloMsg;
    @GetMapping("/")
    public String helloWorld() {
        return "helloMsg";
    }

}
