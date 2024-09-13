package com.symplifica.demoSymplifica.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //@NotBlank(message = "Please, add a name valid.")
    private String name;
    private String description;
    //@NotBlank(message = "Please, add a price valid.")
    private String price;
    //@NotBlank(message = "Please, add a number stock valid.")
    private Integer currentStock;

}
