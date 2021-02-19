package com.papadogiannis.services;

import com.papadogiannis.entities.Account;
import com.papadogiannis.requests.AccountRequest;

import java.util.List;

public interface IAccountService {

    //list of all accounts
    List<Account> getAll();

    //account by id
    Account getAccountById(Long id);

    //new account
    boolean createAccount(AccountRequest request);

    //update account
    Account updateAccount(AccountRequest request,Long id);

    //delete account by id
    boolean deleteAccount(Long id);
}
