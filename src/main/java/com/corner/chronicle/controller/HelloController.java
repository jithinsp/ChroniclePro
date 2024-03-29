package com.corner.chronicle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("register")
public class HelloController {

    @GetMapping
    @ResponseBody
    public String hello(){
        return "Test data hii";
    }
}
