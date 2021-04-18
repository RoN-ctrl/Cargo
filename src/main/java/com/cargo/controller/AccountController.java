package com.cargo.controller;

import com.cargo.api.AccountApi;
import com.cargo.controller.assembler.AccountAssembler;
import com.cargo.controller.model.AccountModel;
import com.cargo.dto.AccountDto;
import com.cargo.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AccountController implements AccountApi {

    private final AccountService accountService;
    private final AccountAssembler accountAssembler;

    @Override
    public AccountModel createAccount(AccountDto accountDto) {
        log.info("controller: createAccount={}", accountDto);
        AccountDto account = accountService.createAccount(accountDto);
        return accountAssembler.toModel(account);
    }

    @Override
    public AccountModel getAccountById(long id) {
        log.info("controller: getAccountById={}", id);
        AccountDto account = accountService.getAccountById(id);
        return accountAssembler.toModel(account);
    }

    @Override
    public AccountModel getAccountByEmail(String email) {
        log.info("controller: getAccountByEmail={}", email);
        AccountDto account = accountService.getAccountByEmail(email);
        return accountAssembler.toModel(account);
    }

    @Override
    public List<AccountModel> getAccountsByLastName(String lastName) {
        log.info("controller: getAccountByLastName={}", lastName);
        List<AccountDto> accounts = accountService.getAccountsByLastName(lastName);
        List<AccountModel> accountModels = new ArrayList<>();

        for (AccountDto account : accounts) {
            accountModels.add(accountAssembler.toModel(account));
        }

        return accountModels;
    }

    @Override
    public AccountModel updateAccount(AccountDto accountDto) {
        log.info("controller: updateAccount={}", accountDto);
        AccountDto account = accountService.updateAccount(accountDto);
        return accountAssembler.toModel(account);
    }

    @Override
    public ResponseEntity<Void> deleteAccountById(long id) {
        log.info("controller: deleteAccountById={}", id);
        accountService.deleteAccountById(id);
        return ResponseEntity.noContent().build();
    }

}
