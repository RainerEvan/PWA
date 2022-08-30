package com.pwa.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pwa.demo.model.Accounts;
import com.pwa.demo.model.FcmTokens;

@Repository
public interface FcmTokenRepository extends JpaRepository<FcmTokens,UUID>{
    List<FcmTokens> findAllByAccount(Accounts account);
}
