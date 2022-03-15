package com.spring.web.demo.service;

import com.spring.web.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    public void addProduct(Product product) {
        products.add(product);
    }


    public List<Product> findAll() {
        return products;
    }
}
