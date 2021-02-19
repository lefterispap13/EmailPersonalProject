package com.papadogiannis.controllers;

import com.papadogiannis.entities.Account;
import com.papadogiannis.requests.AccountRequest;
import com.papadogiannis.responses.AccountResponse;
import com.papadogiannis.responses.Response;
import com.papadogiannis.services.AccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static java.util.Objects.isNull;

@Slf4j
@CrossOrigin(origins = " * ", allowedHeaders = " * ")
@RequestMapping(value="/api/account")
@RestController
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    //list of all the accounts
    @GetMapping(value="/getall")
    public AccountResponse getAll(){
        log.info("Ready to find all the accounts");
        return new AccountResponse("Found all the accounts", accountService.getAll());
    }

    //get account by id
    @GetMapping(value="/getbyid/{id}")
    public AccountResponse getAccountById(@PathVariable Long id){
        log.info("Ready to find account by id {}",id);
        return new AccountResponse("Found the account", accountService.getAccountById(id));
    }

    //create new account
    @PostMapping(value="/newaccount",consumes = "application/json",
            produces = "application/json")
    public Response newAccount(@RequestBody AccountRequest request){
        log.info("Ready to create a new account");
        accountService.createAccount(request);
        log.info("The account has been saved");
        return new Response("The account has been saved");
    }

    //update an existing account
    @PutMapping(value="/updateaccount/{id}",consumes = "application/json",
            produces = "application/json")
    public Response updateAccount(@PathVariable Long id,@RequestBody AccountRequest request){
        log.info("Ready to update the account with id {}",id);
        Account account=accountService.updateAccount(request,id);
        if (isNull(account)){
            return new Response("There is no such account");
        }
        log.info("The account has been updated");
        return new Response("The account has been updated");
    }

    //delete an existing account
    @DeleteMapping(value="/deleteaccount/{id}")
    public Response deleteAccount(@PathVariable Long id){
        log.info("Ready to delete an account");
        accountService.deleteAccount(id);
        return new Response("The account has been deleted");
    }
}
