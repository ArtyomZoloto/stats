package ru.sbrf.dog900.stats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HttpController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/hi")
    public String hi(){
        return "hi";
    }

    @GetMapping("/get")
    public String get(){
        return "get!";
    }
}
