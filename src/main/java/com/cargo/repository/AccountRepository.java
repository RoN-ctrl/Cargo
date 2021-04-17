package com.cargo.repository;

import com.cargo.model.Account;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByEmail(String email);

    List<Account> findAllByLastName(String lastName, Sort sort);

    //    Account createAccount(Account account);
//    Account getAccountById(long id);
//    Account getAccountByEmail(String email);
//    List<Account> getAccountsByLastName(String lastName);
//    Account updateAccountById(long id, Account account);
//    Account updateAccountByEmail(String email, Account account);
//    Account deleteAccountById(long id);
//    Account deleteAccountByEmail(String email);
}
