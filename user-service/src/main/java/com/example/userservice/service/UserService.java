package com.example.userservice.service;

import com.example.userservice.model.Account;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<Account> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
