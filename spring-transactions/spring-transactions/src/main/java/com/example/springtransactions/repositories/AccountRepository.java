package com.example.springtransactions.repositories;


import com.example.springtransactions.models.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class AccountRepository {

    private final JdbcTemplate jdbcTemplate;

    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findAccountById(long id) {
        String sql = "select * from account where id = ?";
        RowMapper<Account> mapper = (r, i) -> {
            Account account = new Account();
            account.setId(r.getLong("id"));
            account.setName(r.getString("name"));
            account.setAmount(r.getBigDecimal("amount"));
            return account;
        };

        return jdbcTemplate.queryForObject(sql, mapper, id);
    }

    public void changeAmount(long id, BigDecimal amount) {
        String sql = "update account set amount = ? where id = ?";
        jdbcTemplate.update(sql, amount, id);
    }

    public List<Account> findAllAccounts() {
        String sql = "select * from account";
        RowMapper<Account> mapper = (r, i) -> {
            Account account = new Account();
            account.setId(r.getLong("id"));
            account.setName(r.getString("name"));
            account.setAmount(r.getBigDecimal("amount"));
            return account;
        };
        return jdbcTemplate.query(sql, mapper);
    }
}
