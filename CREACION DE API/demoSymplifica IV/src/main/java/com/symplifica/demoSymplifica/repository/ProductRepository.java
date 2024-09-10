package com.symplifica.demoSymplifica.repository;

import com.symplifica.demoSymplifica.entity.Order;
import com.symplifica.demoSymplifica.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    Optional<Product> findById(Long id,Product product);
//    Optional<Product> findByName(String name,Product product);
    //Optional<Product> findByNameIgnoreCase(String name, Product product);
}
