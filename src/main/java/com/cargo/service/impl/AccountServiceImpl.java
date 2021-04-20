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
                .orElseThrow(() -> new NoSuchAccountFoundException("No account with such ID found")));
    }

    @Override
    public AccountDto getAccountByEmail(String email) {
        log.info("getting account by email={}", email);
        return mapAccountToAccountDto(accountRepository.findByEmail(email)
                .orElseThrow(() -> new NoSuchAccountFoundException("No account with such EMAIL found")));
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
                .orElseThrow(() -> new NoSuchAccountFoundException("No account with such ID found"));
        List<Parcel> parcelsAccount = account.getParcelsAccount();
        List<ParcelDto> parcelDtos = new ArrayList<>();

        for (Parcel parcel : parcelsAccount) {
            parcelDtos.add(parcelService.mapParcelToParcelDto(parcel));
        }

        return parcelDtos;
    }


    @Override
    public AccountDto updateAccount(AccountDto accountDto) {
        accountRepository.delete(accountRepository.findByEmail(accountDto.getEmail())
                .orElseThrow(NoSuchAccountFoundException::new));
        Account account = mapAccountDtoToAccount(accountDto);
        account = accountRepository.save(account);
        log.info("updating account={}", account);
        return mapAccountToAccountDto(account);
    }

    @Override
    public void deleteAccountById(long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new NoSuchAccountFoundException("No account with such ID found"));
        log.info("deleting account={}", account);
        accountRepository.delete(account);
    }

    private AccountDto mapAccountToAccountDto(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .email(account.getEmail())
                .role(account.getRole())
                .build();
    }

    private Account mapAccountDtoToAccount(AccountDto accountDto) {
        return Account.builder()
                .firstName(accountDto.getFirstName())
                .lastName(accountDto.getLastName())
                .email(accountDto.getEmail())
                .role(accountDto.getRole())
                .password(accountDto.getPassword())
                .build();
    }

}
