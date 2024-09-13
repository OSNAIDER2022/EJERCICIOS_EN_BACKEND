package com.symplifica.demoSymplifica.controller;

import com.symplifica.demoSymplifica.entity.Product;
import com.symplifica.demoSymplifica.error.ProductNotFoundException;
import com.symplifica.demoSymplifica.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("product/save")
    public Product saveProduct(/*@Valid*/ @RequestBody Product product) {
        return productService.saveProduct(product);
      }

    @PutMapping("product/update/{id}")
    public Product updateProductById(@PathVariable Long id, @RequestBody Product product) /*throws ProductNotFoundException*/ {
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("product/delete/{id}")
    public String deleteProductById(@PathVariable Long id) /*throws ProductNotFoundException*/{
        productService.deleteProduct(id);
        return "Se ha eliminado el producto con el id: " + id;
    }

    @GetMapping("product/findbyid/{id}")
    public Product findProductById(@PathVariable Long id)/*throws ProductNotFoundException*/ {
        return productService.findById(id);
    }

    @GetMapping("product/findall")
    public List<Product> findAllProducts()/*throws ProductNotFoundException*/ {
        List<Product> allProducts = productService.listAllProducts();
        return allProducts;
    }

    //custom request "Find By ID" using "product/findbyname/{name}" as same endoinds for boht
    @GetMapping("product/findbynameignorecase/{name}")
    Optional<Product> findProductByName(@PathVariable String name)/*throws ProductNotFoundException*/{
        return productService.findByName(name);
    }

    @GetMapping("product/findbyname/{name}")
    Optional<Product> findProductByNameIgnoreCase(@PathVariable String name)/*throws ProductNotFoundException*/{
        return productService.findByNameIgnoreCase(name);
    }

}
