package com.example.springdatajdbc.service;

import com.example.springdatajdbc.models.Account;
import com.example.springdatajdbc.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount)  {
        Account sender = accountRepository.findById(idSender).orElseThrow(com.example.springdatajdbc.exception.AccountNotFoundException::new);
        Account receiver = accountRepository.findById(idReceiver).orElseThrow(com.example.springdatajdbc.exception.AccountNotFoundException::new);
        accountRepository.changeAmount(idSender, sender.getAmount().subtract(amount));
        accountRepository.changeAmount(idReceiver, receiver.getAmount().add(amount));
    }

    public Iterable<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public List<Account> findAccountsByName(String name) {
        return accountRepository.findAccountsByName(name);
    }
}
