package com.lab1.weblab1.models;

public class Product {
    private int id;
    private String name;
    private double price;

    public Product (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId () {
        return id;
    }

    public String getName () {
        return name;
    }
}
