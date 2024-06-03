package com.example.restservice.controller;


import com.example.restservice.model.ProductOrder;
import com.example.restservice.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class ProductOrderController {

    private final ProductOrderService orderService;

    public ProductOrderController(ProductOrderService orderService) {
        this.orderService = orderService;
    }

    //    @PostMapping("/create")
     public String createProductOrder(@RequestBody ProductOrder productOrder) {
        ProductOrder order = new ProductOrder();
        order.setProductId(productOrder.getProductId());
        order.setSpecification(productOrder.getSpecification());
        order.setPrice(productOrder.getPrice());
        order.setAmount(productOrder.getAmount());
        order.setOrder(productOrder.getOrder());
        orderService.createProductOrder(order);

        return "Product zapisany";
    }
}
