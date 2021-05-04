package com.cargo.service.impl;

import com.cargo.dto.AccountDto;
import com.cargo.dto.ParcelDto;
import com.cargo.exceptions.NoSuchAccountFoundException;
import com.cargo.model.Account;
import com.cargo.model.Parcel;
import com.cargo.repository.AccountRepository;
import com.cargo.service.AccountService;
import com.cargo.service.ParcelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    public static final String NO_ACCOUNT_WITH_SUCH_ID_FOUND = "No account with such ID found";
    public static final String NO_ACCOUNT_WITH_SUCH_EMAIL_FOUND = "No account with such EMAIL found";

    private final AccountRepository accountRepository;
    private final ParcelService parcelService;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = mapAccountDtoToAccount(accountDto);
        account = accountRepository.save(account);
        log.info("creating account={}", account);
        return mapAccountToAccountDto(account);
    }

    @Override
    public AccountDto getAccountById(long id) {
        log.info("getting account by id={}", id);
        return mapAccountToAccountDto(accountRepository.findById(id)
                .orElseThrow(() -> new NoSuchAccountFoundException(NO_ACCOUNT_WITH_SUCH_ID_FOUND)));
    }

    @Override
    public AccountDto getAccountByEmail(String email) {
        log.info("getting account by email={}", email);
        return mapAccountToAccountDto(accountRepository.findByEmail(email)
                .orElseThrow(() -> new NoSuchAccountFoundException(NO_ACCOUNT_WITH_SUCH_EMAIL_FOUND)));
    }

    @Override
    public List<AccountDto> getAccountsByLastName(String lastName) {
        log.info("getting accounts by last name={}", lastName);
        Sort sortByFirstName = Sort.by("firstName");
        List<Account> accounts = accountRepository.findAllByLastName(lastName, sortByFirstName);
        List<AccountDto> accountDtos = new ArrayList<>();

        for (Account account : accounts) {
            accountDtos.add(mapAccountToAccountDto(account));
        }

        return accountDtos;
    }

    @Override
    public List<ParcelDto> getAccountParcels(long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new NoSuchAccountFoundException(NO_ACCOUNT_WITH_SUCH_ID_FOUND));
        List<Parcel> parcelsAccount = account.getParcelsAccount();
        List<ParcelDto> parcelDtos = new ArrayList<>();

        for (Parcel parcel : parcelsAccount) {
            parcelDtos.add(parcelService.mapParcelToParcelDto(parcel));
        }

        return parcelDtos;
    }

    @Override
    public AccountDto updateAccount(long id, AccountDto accountDto) {
        accountRepository.delete(accountRepository.findById(id)
                .orElseThrow(NoSuchAccountFoundException::new));
        Account account = mapAccountDtoToAccount(accountDto);
        account = accountRepository.save(account);
        log.info("updating account={}", account);
        return mapAccountToAccountDto(account);
    }

    @Override
    public void deleteAccountById(long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new NoSuchAccountFoundException(NO_ACCOUNT_WITH_SUCH_ID_FOUND));
        log.info("deleting account={}", account);
        accountRepository.delete(account);
    }

    @Override
    public AccountDto mapAccountToAccountDto(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .email(account.getEmail())
                .role(account.getRole())
                .build();
    }

    @Override
    public Account mapAccountDtoToAccount(AccountDto accountDto) {
        return Account.builder()
                .firstName(accountDto.getFirstName())
                .lastName(accountDto.getLastName())
                .email(accountDto.getEmail())
                .role(accountDto.getRole())
                .password(accountDto.getPassword())
                .build();
    }

}
