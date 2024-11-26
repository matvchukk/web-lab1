package com.lab1.weblab1.services;

import com.lab1.weblab1.models.ProductModel;
import com.lab1.weblab1.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;


import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Cacheable(value = "productCache", key = "#id")
    public Optional<ProductModel> findProductById(Long id, Long timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return productRepository.findById(id);
    }
}
