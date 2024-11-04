package com.example.userservice.service;

import com.example.userservice.model.Account;
import com.example.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Account not found"));
        return new org.springframework.security.core.userdetails.User(account.getEmail(), account.getPassword(), Collections.emptyList());
    }
}
