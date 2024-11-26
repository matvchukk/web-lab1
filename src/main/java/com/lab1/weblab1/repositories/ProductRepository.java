package com.lab1.weblab1.repositories;

import com.lab1.weblab1.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
