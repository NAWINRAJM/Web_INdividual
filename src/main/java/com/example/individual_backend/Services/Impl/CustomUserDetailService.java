package com.example.individual_backend.Services.Impl;

import com.example.individual_backend.Repo.Customer_repo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final Customer_repo customer_repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customer_repo.findByUsername(username).orElseThrow(()-> new EntityNotFoundException("Vatena"));
    }



}
