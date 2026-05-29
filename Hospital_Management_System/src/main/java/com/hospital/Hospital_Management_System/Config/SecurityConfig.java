package com.hospital.Hospital_Management_System.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http)
            throws Exception {

        http

        // Disable CSRF
        .csrf(csrf -> csrf.disable())

        // URL Permission
        .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                        "/",
                        "/login",
                        "/register",
                        "/saveUser",
                        "/css/**",
                        "/js/**")
                .permitAll()

                .anyRequest()
                .permitAll())

        // Disable Spring Security Default Login
        .formLogin(form -> form.disable())

        // Logout
        .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll());

        return http.build();
    }
}