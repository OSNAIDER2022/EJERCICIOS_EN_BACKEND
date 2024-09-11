package com.symplifica.demoSymplifica.repository;

import com.symplifica.demoSymplifica.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);
}
