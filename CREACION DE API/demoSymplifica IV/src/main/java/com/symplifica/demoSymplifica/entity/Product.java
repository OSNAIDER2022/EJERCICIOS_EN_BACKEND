package com.symplifica.demoSymplifica.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private long id;
    private String name;
    private String description;
    private String price;
    private Integer currentStock;


}
