package com.cargo.service.impl;

import com.cargo.dto.AccountDto;
import com.cargo.model.Account;
import com.cargo.model.enums.Role;
import com.cargo.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";
    private static final String EMAIL = "email@ukr.net";
    private static final Role ROLE = Role.ROLE_USER;
    private static final long ID = 0;

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
                .role(ROLE)
                .build();
    }

    private AccountDto testCreateAccountDto() {
        return AccountDto.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .email(EMAIL)
                .role(ROLE)
                .build();
    }

    @Test
    void shouldCreateAccount() {
        Account account = testCreateAccount();
        AccountDto accountDto = testCreateAccountDto();
        when(accountRepository.save(account)).thenReturn(account);

        AccountDto testAccountDto = accountService.createAccount(accountDto);

        assertThat(testAccountDto, allOf(
                hasProperty("id", equalTo(account.getId())),
                hasProperty("firstName", equalTo(account.getFirstName())),
                hasProperty("lastName", equalTo(account.getLastName())),
                hasProperty("email", equalTo(account.getEmail()))
        ));

    }

    @Test
    void shouldGetAccountById() {
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
    void shouldGetAccountByEmail() {
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
    void shouldGetAccountsByLastName() {
        List<Account> accounts = new ArrayList<>();
        Account account = testCreateAccount();
        accounts.add(account);
        when(accountRepository.findAllByLastName(LAST_NAME, Sort.by("firstName"))).thenReturn(accounts);

        List<AccountDto> accountDtos = accountService.getAccountsByLastName(LAST_NAME);

        assertThat(accountDtos.size(), equalTo(accounts.size()));

    }

    @Test
    void shouldUpdateAccount() {
        Account account = testCreateAccount();
        AccountDto newAccount = AccountDto.builder()
                .firstName("New First Name")
                .lastName("New Last Name")
                .email("New Email")
                .role(Role.ROLE_USER)
                .build();

        when(accountRepository.findById(ID)).thenReturn(Optional.of(account));
        when(accountRepository.save(ArgumentMatchers.any(Account.class)))
                .thenReturn(accountService.mapAccountDtoToAccount(newAccount));

        AccountDto accountDto = accountService.updateAccount(0, newAccount);

        assertThat(account, allOf(
                hasProperty("id", equalTo(account.getId())),
                hasProperty("firstName", equalTo(account.getFirstName())),
                hasProperty("lastName", equalTo(account.getLastName())),
                hasProperty("email", equalTo(account.getEmail()))
        ));
        assertThat(accountDto, allOf(
                hasProperty("id", equalTo(newAccount.getId())),
                hasProperty("firstName", equalTo(newAccount.getFirstName())),
                hasProperty("lastName", equalTo(newAccount.getLastName())),
                hasProperty("email", equalTo(newAccount.getEmail()))
        ));

    }

    @Test
    void shouldDeleteAccountById() {
        Account account = testCreateAccount();

        when(accountRepository.findById(ID)).thenReturn(Optional.of(account));

        accountService.deleteAccountById(ID);

        verify(accountRepository).delete(account);

    }

    @Test
    void shouldReturnAccountDto_whenGivenAccount() {
        Account account = testCreateAccount();

        AccountDto accountDto = accountService.mapAccountToAccountDto(account);

        assertThat(accountDto, allOf(
                hasProperty("id", equalTo(account.getId())),
                hasProperty("firstName", equalTo(account.getFirstName())),
                hasProperty("lastName", equalTo(account.getLastName())),
                hasProperty("email", equalTo(account.getEmail())),
                hasProperty("role", equalTo(account.getRole()))
        ));

    }

    @Test
    void shouldReturnAccount_whenGivenAccountDto() {
        AccountDto accountDto = testCreateAccountDto();

        Account account = accountService.mapAccountDtoToAccount(accountDto);

        assertThat(account, allOf(
                hasProperty("id", equalTo(accountDto.getId())),
                hasProperty("firstName", equalTo(accountDto.getFirstName())),
                hasProperty("lastName", equalTo(accountDto.getLastName())),
                hasProperty("email", equalTo(accountDto.getEmail())),
                hasProperty("role", equalTo(accountDto.getRole()))
        ));

    }
}