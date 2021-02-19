package com.papadogiannis.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.papadogiannis.entities.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponse extends Response{

    private List<Account> accounts;

    private Account account;

    public AccountResponse(String msg, List<Account> accounts) {
        super(msg);
        this.accounts = accounts;
    }

    public AccountResponse(String msg, Account account) {
        super(msg);
        this.account = account;
    }
}
