package com.symplifica.demoSymplifica.services;

import com.symplifica.demoSymplifica.entity.Product;
import com.symplifica.demoSymplifica.repository.ProductRepository;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProductServiceImplementation implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product ofTheProduct = productRepository.findById(id).get();
        if(Objects.nonNull(product.getName()) && !"".equalsIgnoreCase(product.getName())){
            ofTheProduct.setName(product.getName());
        }
        if(Objects.nonNull(product.getDescription()) && !"".equalsIgnoreCase(product.getDescription())){
            ofTheProduct.setDescription(product.getDescription());
        }
        if(Objects.nonNull(product.getPrice()) && !"".equalsIgnoreCase(product.getPrice())){
            ofTheProduct.setPrice(product.getPrice());
        }
        if(Objects.nonNull(product.getCurrentStock()) && !"".equalsIgnoreCase(String.valueOf(product.getCurrentStock()))){
            ofTheProduct.setCurrentStock(product.getCurrentStock());
        }

        return productRepository.save(ofTheProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> listAllProducts() {
        return productRepository.findAll();
    }
}
