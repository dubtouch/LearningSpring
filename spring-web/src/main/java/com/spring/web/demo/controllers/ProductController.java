package com.spring.web.demo.controllers;


import com.spring.web.demo.model.Product;
import com.spring.web.demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model) {
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }

    @PostMapping("/products")
    public String addProduct(Product product, Model model) {

        productService.addProduct(product);
        var products = productService.findAll();
        model.addAttribute("products", products);
        return "products.html";
    }
}
