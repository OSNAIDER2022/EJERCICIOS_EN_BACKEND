package com.symplifica.demoSymplifica.services;

import com.symplifica.demoSymplifica.entity.Product;
import com.symplifica.demoSymplifica.error.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    Product saveProduct(Product product);
    Product updateProduct(Long id, Product product) /*throws ProductNotFoundException*/;
    void deleteProduct(Long id) /*throws ProductNotFoundException*/;
    Product findById(Long id)/*throws ProductNotFoundException*/;
    List<Product> listAllProducts() /*throws ProductNotFoundException*/;
    Optional<Product> findByName(String name);
    Optional<Product> findByNameIgnoreCase(String name);
}
