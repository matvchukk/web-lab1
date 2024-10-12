package com.lab1.weblab1.controllers;

import com.lab1.weblab1.models.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductControllerTests {
    @Test
    public void getProductTest () {
        ProductController productController = new ProductController();
        int productId = 10;
        Product expectedProduct = new Product(productId, productId + " name");
        Product actualProduct = productController.getProduct(productId);
        assertEquals(expectedProduct.getId(), actualProduct.getId());
        assertEquals(expectedProduct.getName(), actualProduct.getName());
    }
}
