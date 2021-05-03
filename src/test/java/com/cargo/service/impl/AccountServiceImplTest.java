package com.cargo.service.impl;

import com.cargo.dto.AccountDto;
import com.cargo.model.Account;
import com.cargo.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class AccountServiceImplTest {

    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static final String EMAIL = "email@ukr.net";
    private static final long ID = 1;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;

    private Account testCreateAccount() {
        return Account.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .email(EMAIL)
                .build();
    }

    private AccountDto testCreateAccountDto() {
        return AccountDto.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .email(EMAIL)
                .build();
    }

    @Test
    void createAccount() {
    }

    @Test
    void getAccountById() {
        Account account = testCreateAccount();
        when(accountRepository.findById(ID)).thenReturn(Optional.of(account));

        AccountDto accountDto = accountService.getAccountById(ID);

        assertThat(accountDto, allOf(
                hasProperty("id", equalTo(account.getId())),
                hasProperty("firstName", equalTo(account.getFirstName())),
                hasProperty("lastName", equalTo(account.getLastName())),
                hasProperty("email", equalTo(account.getEmail()))
        ));

    }

    @Test
    void getAccountByEmail() {
        Account account = testCreateAccount();
        when(accountRepository.findByEmail(EMAIL)).thenReturn(Optional.of(account));

        AccountDto accountDto = accountService.getAccountByEmail(EMAIL);

        assertThat(accountDto, allOf(
                hasProperty("id", equalTo(account.getId())),
                hasProperty("firstName", equalTo(account.getFirstName())),
                hasProperty("lastName", equalTo(account.getLastName())),
                hasProperty("email", equalTo(account.getEmail()))
        ));

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