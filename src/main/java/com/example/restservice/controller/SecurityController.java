package com.example.restservice.controller;


import com.example.restservice.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/security/")
public class SecurityController {

    @ResponseBody
    @GetMapping(path="/{id}")
    public String generateToken(){
        return "";
    }
}
