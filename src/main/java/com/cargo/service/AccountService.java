package com.cargo.service;

import com.cargo.dto.AccountDto;
import com.cargo.dto.ParcelDto;
import com.cargo.model.Parcel;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(long id);

    AccountDto getAccountByEmail(String email);

    List<AccountDto> getAccountsByLastName(String lastName);

    List<ParcelDto> getAccountParcels(long id);

    AccountDto updateAccount(AccountDto accountDto);

    void deleteAccountById(long id);
}
