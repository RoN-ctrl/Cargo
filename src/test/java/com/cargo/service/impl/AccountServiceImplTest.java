package com.cargo.service.impl;

import com.cargo.repository.AccountRepository;
import com.cargo.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
class AccountServiceImplTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @Test
    void createAccount() {
    }

    @Test
    void getAccountById() {
    }

    @Test
    void getAccountByEmail() {
    }

    @Test
    void getAccountsByLastName() {
    }

    @Test
    void getAccountParcels() {
    }

    @Test
    void updateAccount() {
    }

    @Test
    void deleteAccountById() {
    }

    @Test
    void mapAccountToAccountDto() {
    }

    @Test
    void mapAccountDtoToAccount() {
    }
}