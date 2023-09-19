package com.example.Imagenius.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registration/")
public class RegistrationController {

    @PostMapping()
    public String registration(){

    }
}
