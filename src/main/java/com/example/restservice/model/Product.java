package com.example.restservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name ="name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "product_number", length = 128)
    private String productNumber;

    @Column(name = "state", length = 64)
    private String state;

    @Column(name = "textile", length = 512)
    private String textile;

    @Column(name = "color", length = 256)
    private String color;

    @Column(name = "completion_time", length = 64)
    private String completionTime;

    @Column(name = "finish", length = 512)
    private String finish;

    @Column(name = "specification", columnDefinition = "json")
    private String specification;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "id")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}

