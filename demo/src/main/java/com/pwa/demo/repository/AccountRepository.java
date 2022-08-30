package com.pwa.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pwa.demo.model.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts,UUID> {
    
}
