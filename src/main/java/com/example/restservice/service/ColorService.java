package com.example.restservice.service;

import org.springframework.stereotype.Service;

import com.example.restservice.model.Color;
import com.example.restservice.repository.ColorRepository;

import java.util.Optional;

@Service
public class ColorService {
    private final ColorRepository colorRepository;

    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    public Optional<Color> getProductById(Integer id) {
        return colorRepository.findById(id);
    }

}