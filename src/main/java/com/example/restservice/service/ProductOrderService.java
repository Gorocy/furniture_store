package com.example.restservice.service;

import com.example.restservice.model.ProductOrder;
import com.example.restservice.repository.ProductOrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProductOrderService {
    @Autowired
    private ProductOrderRepository repository;

    public ProductOrder createProductOrder(ProductOrder order) {
        return repository.save(order);
    }
}
