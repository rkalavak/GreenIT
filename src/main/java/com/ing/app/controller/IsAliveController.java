package com.ing.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IsAliveController {

    @GetMapping("/isAlive")
    public String isAlive() {
        return "GreenIT App Is Running...";
    }
}