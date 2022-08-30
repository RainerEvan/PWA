package com.pwa.demo.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwa.demo.model.Accounts;
import com.pwa.demo.model.FcmTokens;
import com.pwa.demo.repository.AccountRepository;
import com.pwa.demo.repository.FcmTokenRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FcmTokenService {
    
    @Autowired
    private final FcmTokenRepository fcmTokenRepository;
    @Autowired
    private final AccountRepository accountRepository;

    public List<FcmTokens> getAllFcmTokensForAccount(UUID accountId){
        Accounts account = accountRepository.findById(accountId)
            .orElseThrow(() -> new IllegalStateException("Account with current id not found"));

        return fcmTokenRepository.findAllByAccount(account);
    }
    
    public FcmTokens addFcmToken(UUID accountId, String token){
        Accounts account = accountRepository.findById(accountId)
            .orElseThrow(() -> new IllegalStateException("Account with current id not found"));

        FcmTokens fcmToken = new FcmTokens();
        fcmToken.setAccount(account);
        fcmToken.setToken(token);
        fcmToken.setTimestamp(OffsetDateTime.now());

        return fcmTokenRepository.save(fcmToken);
    }
}
