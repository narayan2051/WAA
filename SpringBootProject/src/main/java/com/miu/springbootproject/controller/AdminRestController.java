package com.miu.springbootproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/home")
public class AdminRestController {

    @GetMapping
    public String adminIndex(){
        return "Admin homePage";
    }
}
