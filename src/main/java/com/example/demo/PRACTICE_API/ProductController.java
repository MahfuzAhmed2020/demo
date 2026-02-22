package com.example.demo.PRACTICE_API;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProductController {

    @GetMapping("/products")
    public List<Product> getProducts() {

        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 800));
        products.add(new Product("Phone", 500));
        products.add(new Product("Tablet", 300));
        products.add(new Product("Headphones", 100));
        products.add(new Product("Mouse", 50));

        return products;
    }
}