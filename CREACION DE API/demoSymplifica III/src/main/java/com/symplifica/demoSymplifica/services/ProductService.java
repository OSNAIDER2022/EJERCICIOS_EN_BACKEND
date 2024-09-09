package com.symplifica.demoSymplifica.services;

import com.symplifica.demoSymplifica.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProductService {
    Product saveProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<Product> listAllProducts();
}
