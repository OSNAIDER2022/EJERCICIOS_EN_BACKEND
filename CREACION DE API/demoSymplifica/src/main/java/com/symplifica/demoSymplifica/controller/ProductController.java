package com.symplifica.demoSymplifica.controller;

import com.symplifica.demoSymplifica.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ProductController {
    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/products")
    public Product Hello(@RequestParam(value = "name", defaultValue = "Everybody") String name){
        return new Product(counter.incrementAndGet(), String.format(template, name));
        //return null;
    }

}
