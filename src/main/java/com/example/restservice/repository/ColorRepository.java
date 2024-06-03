package com.example.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restservice.model.Color;

public interface ColorRepository extends JpaRepository<Color, Integer> {
}

