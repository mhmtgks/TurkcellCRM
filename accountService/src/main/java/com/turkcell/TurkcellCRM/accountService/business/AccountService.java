package com.turkcell.TurkcellCRM.accountService.business;


import com.turkcell.TurkcellCRM.accountService.core.Account;

import java.util.List;

public interface AccountService {
    Account add(Account account);
    List<Account> getAll();
}
