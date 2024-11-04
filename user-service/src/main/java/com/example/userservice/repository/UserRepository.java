package com.example.userservice.repository;

import com.example.userservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByEmail(String email);
}