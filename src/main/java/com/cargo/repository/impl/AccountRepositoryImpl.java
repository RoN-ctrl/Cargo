//package com.cargo.repository.impl;
//
//import com.cargo.model.Account;
//import com.cargo.repository.AccountRepository;
//import com.cargo.repository.exceptions.NoSuchEmailFoundException;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Repository
//public class AccountRepositoryImpl implements AccountRepository {
//
//    private static final String NO_SUCH_EMAIL_FOUND = "No account with such email";
//
//    private final List<Account> accounts = new ArrayList<>();
//
//    @Override
//    public Account createAccount(Account account) {
//        accounts.add(account);
//        return account;
//    }
//
//    @Override
//    public Account getAccountById(long id) {
//        return accounts.stream()
//                .filter(acc -> acc.getId() == id)
//                .findAny()
//                .orElseThrow(NoSuchEmailFoundException::new);
//    }
//
//    @Override
//    public Account getAccountByEmail(String email) {
//        return accounts.stream()
//                .filter(acc -> acc.getEmail().equals(email))
//                .findAny()
//                .orElseThrow(NoSuchEmailFoundException::new);
//    }
//
//    @Override
//    public List<Account> getAccountsByLastName(String lastName) {
//        return accounts.stream()
//                .filter(acc -> acc.getLastName().equals(lastName))
//                .collect((Collectors.toList()));
//    }
//
//    @Override
//    public Account updateAccountById(long id, Account account) {
//        boolean isDeleted = accounts.removeIf(acc -> acc.getId() == id);
//        if (isDeleted) {
//            accounts.add(account);
//        } else {
//            throw new NoSuchEmailFoundException(NO_SUCH_EMAIL_FOUND);
//        }
//        return account;
//    }
//
//    @Override
//    public Account updateAccountByEmail(String email, Account account) {
//        boolean isDeleted = accounts.removeIf(acc -> acc.getEmail().equals(email));
//        if (isDeleted) {
//            accounts.add(account);
//        } else {
//            throw new NoSuchEmailFoundException(NO_SUCH_EMAIL_FOUND);
//        }
//        return account;
//    }
//
//    @Override
//    public Account deleteAccountById(long id) {
//        Account account = accounts.stream()
//                .filter(acc -> acc.getId() == id)
//                .findAny()
//                .orElseThrow(NoSuchEmailFoundException::new);
//        boolean isDeleted = accounts.remove(account);
//        if (isDeleted) {
//            return account;
//        }
//        throw new NoSuchEmailFoundException(NO_SUCH_EMAIL_FOUND);
//    }
//
//    @Override
//    public Account deleteAccountByEmail(String email) {
//        Account account = accounts.stream()
//                .filter(acc -> acc.getEmail().equals(email))
//                .findAny()
//                .orElseThrow(NoSuchEmailFoundException::new);
//        boolean isDeleted = accounts.remove(account);
//        if (isDeleted) {
//            return account;
//        }
//        throw new NoSuchEmailFoundException(NO_SUCH_EMAIL_FOUND);
//    }
//
//}
