package com.cargo.repository;

import com.cargo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
//    Account createAccount(Account account);
//    Account getAccountById(long id);
//    Account getAccountByEmail(String email);
//    List<Account> getAccountsByLastName(String lastName);
//    Account updateAccountById(long id, Account account);
//    Account updateAccountByEmail(String email, Account account);
//    Account deleteAccountById(long id);
//    Account deleteAccountByEmail(String email);
}
