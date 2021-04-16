package com.cargo.service.impl;

import com.cargo.model.Account;
import com.cargo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl {

    private final AccountRepository accountRepository;

    public Account getAccountById(long id) {
        return null;
    }
}
