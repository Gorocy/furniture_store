package com.example.restservice.service;

import org.springframework.stereotype.Service;

import com.example.restservice.model.Product;
import com.example.restservice.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

}