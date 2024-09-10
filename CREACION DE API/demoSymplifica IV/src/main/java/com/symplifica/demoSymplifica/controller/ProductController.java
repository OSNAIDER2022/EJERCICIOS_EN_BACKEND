package com.symplifica.demoSymplifica.controller;

import com.symplifica.demoSymplifica.entity.Product;
import com.symplifica.demoSymplifica.errors.LocalNotFoundException;
import com.symplifica.demoSymplifica.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("saveproduct")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
      }

    @PutMapping("updateproduct/{id}")
    public Product updateProductById(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("deleteproduct/{id}")
    public String teProductById(@PathVariable Long id){
        productService.deleteProduct(id);
        return "Se ha eliminado el producto con el id: " + id;
    }

    @GetMapping("findallproducts")
    public List<Product> findAllProducts()throws LocalNotFoundException {
        return productService.listAllProducts();
    }

//    @GetMapping("findbynameproduct/{name}")
//    public Optional<Product> ProductfindByNameIgnoreCase(@PathVariable String name, @RequestBody Product product){
//        return productService.findByNameIgnoreCase(name);
//    }
}
