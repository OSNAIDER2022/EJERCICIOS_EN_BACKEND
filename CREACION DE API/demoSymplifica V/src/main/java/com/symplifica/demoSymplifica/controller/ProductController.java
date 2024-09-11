package com.symplifica.demoSymplifica.controller;

import com.symplifica.demoSymplifica.entity.Product;
import com.symplifica.demoSymplifica.error.ProductNotFoundException;
import com.symplifica.demoSymplifica.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("product/saveproduct")
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
      }

    @PutMapping("product/updateproduct/{id}")
    public Product updateProductById(@PathVariable Long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.updateProduct(id,product);
    }

    @DeleteMapping("product/deleteproduct/{id}")
    public String deleteProductById(@PathVariable Long id) throws ProductNotFoundException{
        productService.deleteProduct(id);
        return "Se ha eliminado el producto con el id: " + id;
    }

    @GetMapping("product/findproductbyname/{name}")
    public Product findProductByName(@PathVariable String name)throws ProductNotFoundException{
        return productService.findProductByName(name);
    }

    @GetMapping("product/findproductbyid/{id}")
    public Product findProductById(@PathVariable Long id)throws ProductNotFoundException {
        return productService.findProductById(id);
    }

    @GetMapping("product/findallproducts")
    public List<Product> findAllProducts()throws ProductNotFoundException {
        return productService.listAllProducts();
    }


}
