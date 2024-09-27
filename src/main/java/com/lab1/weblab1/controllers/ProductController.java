package com.lab1.weblab1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.lab1.weblab1.models.Product;

@RestController
public class ProductController {

    @GetMapping("/products/{productId}")
    public Product getProduct(@PathVariable int productId) {
        return new Product(productId, productId + " name");
    }
}
