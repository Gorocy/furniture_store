package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

@Entity
@Table(name = "product_order")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("idProduct")
    @Column(name = "id_product")
    private Integer idProduct;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column(name = "specification",columnDefinition = "json")
    private String specification;

    @Column(name ="price")
    private Double price;

    @Column(name ="amount")
    private Integer amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return idProduct;
    }

    public void setProductId(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Map<String, Object> getSpecification() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(specification, Map.class); // Deserializacja z JSON na mapę
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error parsing JSON", e);
        }
    }

    public void setSpecification(Map<String, Object> specificationMap) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            this.specification = objectMapper.writeValueAsString(specificationMap); // Serializacja z mapy na JSON
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error writing JSON", e);
        }
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}