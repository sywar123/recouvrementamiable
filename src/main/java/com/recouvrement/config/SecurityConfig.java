package com.recouvrement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // désactive CSRF pour les requêtes API
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated() // toutes les requêtes nécessitent une auth
            )
            .httpBasic(Customizer.withDefaults()); // active l'authentification Basic
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // utilisateur en mémoire : siwar / password123
        UserDetails user = User.withUsername("siwar")
            .password("{noop}password123") // mot de passe en clair avec {noop}
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // encodeur "no operation" (pas de hash)
    }
}
