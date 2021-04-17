package com.cargo.controller;

import com.cargo.dto.AccountDto;
import com.cargo.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public AccountDto createAccount(AccountDto accountDto) {
        log.info("controller: createAccount={}", accountDto);
        return accountService.createAccount(accountDto);
    }

    public AccountDto getAccountById(long id) {
        log.info("controller: getAccountById={}", id);
        return accountService.getAccountById(id);
    }

}
