package com.papadogiannis.services;

import com.papadogiannis.entities.Account;
import com.papadogiannis.entities.Role;
import com.papadogiannis.repository.AccountRepository;
import com.papadogiannis.requests.AccountRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.papadogiannis.constants.Constants.USER;
import static java.util.Objects.isNull;

@Service
@Slf4j
public class AccountServiceImpl implements IAccountService{

    @Autowired
    private AccountRepository accountRepository;

    // get all the accounts
    @Override
    public List<Account> getAll() {
        log.info("Ready to find all the accounts");
        return accountRepository.findAll();
    }

    // get the account by id
    @Override
    public Account getAccountById(Long id) {
        log.info("Ready to find the Account with id {}",id);
        return accountRepository.findById(id).orElse(null);
    }

    // create a new account
    @Override
    public boolean createAccount(AccountRequest request) {
        log.info("Ready to create a new account. The request is {}",request);
        Role role = new Role(2L,"User");
        Account account=new Account(request.getFirstName(), request.getLastName()
        ,request.getDateOfBirth(), request.getGender(), request.getPassword(),
                request.getEmail(), role);
        Account newAccount=accountRepository.save(account);
        log.info("The new account is {}",newAccount);
        log.info("The account has been inserted to the DB");
        return true;
    }

    // update an existing account by id
    @Override
    public Account updateAccount(AccountRequest request,Long id) {
        log.info("Ready to find the Account with id {}",id);
        Account existingAccount=accountRepository.findById(id).orElse(null);
        if(isNull(existingAccount)){
            log.info("The Account with id {} does not exists",id);
            return null;
        }
        Role role = new Role(2L,"User");
        log.info("Ready to update the existing account");
        existingAccount.setFirstName(request.getFirstName());
        existingAccount.setLastName(request.getLastName());
        existingAccount.setDateOfBirth(request.getDateOfBirth());
        existingAccount.setEmail(request.getEmail());
        existingAccount.setPassword(request.getPassword());
        existingAccount.setGender(request.getGender());
        existingAccount.setRole(role);
        Account updatedAccount=accountRepository.save(existingAccount);
        log.info("the Account has been successfully updated");
        return updatedAccount;
    }

    // delete an account by id
    @Override
    public boolean deleteAccount(Long id) {
        log.info("Ready to delete an account");
        if (accountRepository.existsById(id)){
            accountRepository.deleteById(id);
            log.info("Account  successfully deleted");
            return true;
        }
        log.info("Account with this id {} does not exists",id);
        return false;
    }
}
