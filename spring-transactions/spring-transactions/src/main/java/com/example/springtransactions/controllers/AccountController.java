package com.example.springtransactions.controllers;


import com.example.springtransactions.models.Account;
import com.example.springtransactions.models.TransferRequest;
import com.example.springtransactions.services.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private final TransferService service;

    public AccountController(TransferService service) {
        this.service = service;
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request) {
        service.transferMoney(request.getSenderAccountId(), request.getReceiverAccountId(), request.getAmount());
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return service.getAllAccount();
    }
}
