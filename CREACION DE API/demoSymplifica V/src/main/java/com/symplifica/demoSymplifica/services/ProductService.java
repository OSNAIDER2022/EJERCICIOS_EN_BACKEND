package com.symplifica.demoSymplifica.services;

import com.symplifica.demoSymplifica.entity.Product;
import com.symplifica.demoSymplifica.error.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product saveProduct(Product product);
    Product updateProduct(Long id, Product product) throws ProductNotFoundException;
    void deleteProduct(Long id) throws ProductNotFoundException;
    Product findProductById(Long id)throws ProductNotFoundException;
    Product findProductByName(String name)throws ProductNotFoundException;
    List<Product> listAllProducts()throws ProductNotFoundException;

}
