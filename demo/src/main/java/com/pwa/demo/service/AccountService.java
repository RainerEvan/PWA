package com.pwa.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwa.demo.model.Accounts;
import com.pwa.demo.repository.AccountRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountService {
    
    @Autowired
    private final AccountRepository accountRepository;

    public List<Accounts> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Accounts addAccount(String username){
        Accounts account = new Accounts();
        account.setUsername(username);
        return accountRepository.save(account);
    }
}
