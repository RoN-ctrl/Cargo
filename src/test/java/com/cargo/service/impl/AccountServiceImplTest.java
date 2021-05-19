package com.cargo.service.impl;

import com.cargo.dto.AccountDto;
import com.cargo.model.Account;
import com.cargo.model.enums.Role;
import com.cargo.repository.AccountRepository;
import org.hamcrest.Matcher;
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

import static com.cargo.test.util.TestDataUtil.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountRepository accountRepository;

    @Test
    void shouldCreateAccount() {
        Account account = testCreateAccount();
        AccountDto accountDto = testCreateAccountDto();
        when(accountRepository.save(account)).thenReturn(account);

        AccountDto testAccountDto = accountService.createAccount(accountDto);

        assertThat(testAccountDto, getAccountMatcher(account));

    }

    @Test
    void shouldGetAccountById() {
        Account account = testCreateAccount();
        when(accountRepository.findById(ID)).thenReturn(Optional.of(account));

        AccountDto accountDto = accountService.getAccountById(ID);

        assertThat(accountDto, getAccountMatcher(account));

    }

    @Test
    void shouldGetAccountByEmail() {
        Account account = testCreateAccount();
        when(accountRepository.findByEmail(EMAIL)).thenReturn(Optional.of(account));

        AccountDto accountDto = accountService.getAccountByEmail(EMAIL);

        assertThat(accountDto, getAccountMatcher(account));

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

        assertThat(accountDto, getAccountMatcher(account));

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

    private Matcher<AccountDto> getAccountMatcher(Account account) {
        return allOf(
                hasProperty("id", equalTo(account.getId())),
                hasProperty("firstName", equalTo(account.getFirstName())),
                hasProperty("lastName", equalTo(account.getLastName())),
                hasProperty("email", equalTo(account.getEmail()))
        );
    }
}