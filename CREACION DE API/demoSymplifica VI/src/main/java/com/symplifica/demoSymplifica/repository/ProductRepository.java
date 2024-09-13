package com.symplifica.demoSymplifica.repository;

import com.symplifica.demoSymplifica.entity.Product;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
/*
    //with JPQL
    @Query("select p from Product p where p.name = :name")
    Optional<Product> findByName(String name);

*/

    //with control inversion JPA
    Optional<Product> findByName(String name);
    Optional<Product> findByNameIgnoreCase(String name);

}