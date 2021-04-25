package com.cargo.service;

import com.cargo.dto.AccountDto;
import com.cargo.dto.ParcelDto;
import com.cargo.model.Account;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(long id);

    AccountDto getAccountByEmail(String email);

    List<AccountDto> getAccountsByLastName(String lastName);

    List<ParcelDto> getAccountParcels(long id);

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = SQLException.class)
    AccountDto updateAccount(AccountDto accountDto);

    void deleteAccountById(long id);

    AccountDto mapAccountToAccountDto(Account account);

    Account mapAccountDtoToAccount(AccountDto accountDto);
}
