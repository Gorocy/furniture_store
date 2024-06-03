package com.example.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.restservice.model.Color;
import com.example.restservice.repository.ColorRepository;

@Controller
@RequestMapping(path="/color")
public class ColorController {

    @Autowired
    private ColorRepository colorRepository;



    @GetMapping(path="/all")
    public  @ResponseBody Iterable<Color> getAllColors() {
        return colorRepository.findAll();
    }
    
    @ResponseBody
    @GetMapping(path="/{id}")
    public Color getColorById(@PathVariable Integer id) throws Exception {
        return colorRepository.findById(id).orElseThrow(() -> new Exception("Chujowy kolor wybrałes"));
    }

    
}