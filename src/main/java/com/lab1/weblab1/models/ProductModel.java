package com.lab1.weblab1.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public ProductModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ProductModel() {}
    public Long getId () {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}