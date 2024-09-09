package com.symplifica.demoSymplifica.services;

import com.symplifica.demoSymplifica.entity.Product;
import com.symplifica.demoSymplifica.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }
}
