package com.example.restservice.service;


import com.example.restservice.controller.ProductOrderController;
import com.example.restservice.model.Order;
import com.example.restservice.model.ProductOrder;
import com.example.restservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductOrderService productOrderService;

    @Transactional
    public Order createOrder(Order orderDTO) {
        Order order = new Order();

        order.setEmail(orderDTO.getEmail());
        order.setPaymentMethod(orderDTO.getPaymentMethod());
        order.setAddress(orderDTO.getAddress());

        List<ProductOrder> configurations = orderDTO.getConfigurations().stream()
                .map(cfg -> {
                    ProductOrder orderP = new ProductOrder();
                    orderP.setProductId(cfg.getProductId());
                    orderP.setSpecification(cfg.getSpecification());
                    orderP.setPrice(cfg.getPrice());
                    orderP.setAmount(cfg.getAmount());
                    orderP.setOrder(order);
                    return orderP;
                })
                .collect(Collectors.toList());

        order.setConfigurations(configurations);
        orderRepository.save(order);

        return order;
    }
}
