package com.cargo.service;

import com.cargo.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(long id);

    AccountDto getAccountByEmail(String email);

    List<AccountDto> getAccountsByLastName(String lastName);

    AccountDto updateAccount(AccountDto accountDto);

    void deleteAccountById(long id);
}
