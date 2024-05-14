package com.turkcell.TurkcellCRM.accountService.business;

import com.turkcell.TurkcellCRM.accountService.core.Account;
import com.turkcell.TurkcellCRM.accountService.dataAccess.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class AccountManager implements AccountService{
   private AccountRepository accountRepository;
    @Override
    public Account add(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAll() {
        List<Account> accounts=accountRepository.findAll();
        return accounts.stream().toList();
    }
}
