package com.example.eregistrardemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping(value = {"/","/eregistrar/home", "/home", "/eregistrar"})
    public String displayHomePage(){ return "/home/index";
    }
}
