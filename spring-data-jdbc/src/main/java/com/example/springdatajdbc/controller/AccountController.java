package com.example.springdatajdbc.controller;


import com.example.springdatajdbc.models.Account;
import com.example.springdatajdbc.models.TransferRequest;
import com.example.springdatajdbc.service.TransferService;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.AccountNotFoundException;

@RestController
public class AccountController {
    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest request) {
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(@RequestParam(required = false) String name) {
        if (name == null) return transferService.getAllAccounts();
        return transferService.findAccountsByName(name);
    }
}
