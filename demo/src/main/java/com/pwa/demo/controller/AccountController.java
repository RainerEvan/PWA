package com.pwa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pwa.demo.model.Accounts;
import com.pwa.demo.service.AccountService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/accounts")
@AllArgsConstructor
public class AccountController {
    
    @Autowired
    private final AccountService accountService;

    @GetMapping("/all")
    public List<Accounts> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @PostMapping("/add")
    public Accounts addAccount(@RequestBody String username){
        Accounts account = accountService.addAccount(username);

        return account;
    }
}
