package com.hospital.Hospital_Management_System.Service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.hospital.Hospital_Management_System.Entity.User;
import com.hospital.Hospital_Management_System.Repository.UserRepository;

@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(
            String username)
            throws UsernameNotFoundException {

        Optional<User> user =
                repo.findByUsername(username);

        if(user.isEmpty()) {
            throw new UsernameNotFoundException(
                    "User Not Found");
        }

        return org.springframework.security.core.userdetails
                .User
                .withUsername(
                        user.get().getUsername())
                .password(
                        "{noop}" +
                        user.get().getPassword())
                .roles("USER")
                .build();
    }
}
