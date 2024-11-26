package com.lab1.weblab1.controllers;

import com.lab1.weblab1.data.ProductData;
import com.lab1.weblab1.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.repository.query.Param;


@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products/{productId}")
    public ProductData getProduct(@PathVariable Long productId, @Param("timeout") Long timeout) {
        return productService.findProductById(productId, timeout)
                .map(p -> new ProductData(p.getName()))
                .orElseGet(() -> new ProductData("UNKNOWN"));
    }
}
