package com.example.springdatasourcejdbctemplate.controllers;


import com.example.springdatasourcejdbctemplate.models.Purchase;
import com.example.springdatasourcejdbctemplate.repositories.PurchaseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PurchaseController {
    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }
    @PostMapping("/purchase")
    public void storePurchase(@RequestBody Purchase purchase) {
        purchaseRepository.storePurchase(purchase);
    }
    @GetMapping("/purchases")
    public List<Purchase> findPurchases() {
        return purchaseRepository.findAllPurchases();
    }
}
