package com.symplifica.demoSymplifica.services;

import com.symplifica.demoSymplifica.entity.Product;
import com.symplifica.demoSymplifica.errors.LocalNotFoundException;
import com.symplifica.demoSymplifica.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
/*
    @Override
    public Optional<Product> findById(Long id, Product product) {
        return productRepository.findById(id);
    }

    @Override
    public Product findByName(String name, Product product) {
        return null;
    }
*/
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
    public List<Product> listAllProducts()  throws LocalNotFoundException {
        Optional<List<Product>> product = Optional.of(productRepository.findAll());
        if (!product.isPresent()){
            throw new LocalNotFoundException("Products are not Available.");
        }
        return product.get();
    }

//    @Override
//    public Optional<Product> findByNameIgnoreCase(String name) {
//        return Optional.empty(productRepository.findByNameIgnoreCase(name,product));
//    }


}
