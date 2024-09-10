package com.symplifica.demoSymplifica.services;

import com.symplifica.demoSymplifica.entity.Product;
import com.symplifica.demoSymplifica.errors.LocalNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    Product saveProduct(Product product);
//    Optional<Product> findById(Long id, Product product);
//    Product findByName(String name, Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<Product> listAllProducts()  throws LocalNotFoundException;

}
