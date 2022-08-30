package com.pwa.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pwa.demo.model.FcmTokens;
import com.pwa.demo.service.FcmTokenService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/fcmtokens")
@AllArgsConstructor
public class FcmTokenController {
    
    @Autowired
    private final FcmTokenService fcmTokenService;

    @GetMapping("/all")
    public List<FcmTokens> getAllFcmTokensForAccount(@RequestParam("accountId") UUID accountId){
        return fcmTokenService.getAllFcmTokensForAccount(accountId);
    }

    @PostMapping("/add")
    public FcmTokens addFcmToken(@RequestParam("accountId") UUID accountId, @RequestBody String token){
        return fcmTokenService.addFcmToken(accountId, token);
    }
}
