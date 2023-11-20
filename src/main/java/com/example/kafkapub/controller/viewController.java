package com.example.kafkapub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class viewController {
    @GetMapping("/pub_page")
    public String a(){
        return "pub_page";
    }
}
