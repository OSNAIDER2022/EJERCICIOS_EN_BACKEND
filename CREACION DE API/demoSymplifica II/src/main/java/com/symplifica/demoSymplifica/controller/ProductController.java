package com.symplifica.demoSymplifica.controller;

import com.symplifica.demoSymplifica.entity.Product;
import com.symplifica.demoSymplifica.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ProductController {
    
    @Autowired
    ProductService productService;

    @GetMapping("/findall")
    public List<Product> findAllProducts(){
        return findAllProducts();
    }


}
