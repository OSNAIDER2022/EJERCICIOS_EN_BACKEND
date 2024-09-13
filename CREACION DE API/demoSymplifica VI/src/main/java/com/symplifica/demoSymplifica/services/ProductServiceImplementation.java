package com.symplifica.demoSymplifica.services;

import com.symplifica.demoSymplifica.entity.Product;
import com.symplifica.demoSymplifica.error.ProductNotFoundException;
import com.symplifica.demoSymplifica.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class ProductServiceImplementation implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) /*throws ProductNotFoundException*/{
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
    public void deleteProduct(Long id) /*throws ProductNotFoundException*/{
        Optional<Product> product = productRepository.findById(id);
/*
        if(!product.isPresent()){
            throw  new ProductNotFoundException("The product with id: "+ id +", doesn't exist in the inventary");
        }
*/
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(Long id) /*throws ProductNotFoundException*/{
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> listAllProducts() /*throws ProductNotFoundException*/ {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findByName(String name) {
        //return Optional.empty();
        return productRepository.findByName(name);
    }

    @Override
    public Optional<Product> findByNameIgnoreCase(String name) {
        //return Optional.empty();
        return productRepository.findByNameIgnoreCase(name);
    }


}
