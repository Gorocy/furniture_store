package com.example.restservice.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.example.restservice.model.Product;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer id;

    @Column(name = "name_category")
    private String nameCategory;

    @Column(name = "details_category", columnDefinition = "json")
    private String detailsCategory;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
    @JsonIgnoreProperties("category")
    private Set<Product> products;
}
