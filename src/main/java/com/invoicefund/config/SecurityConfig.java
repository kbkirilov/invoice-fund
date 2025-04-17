package com.invoicefund.config;

import com.invoicefund.exceptions.EntityNotFoundException;
import com.invoicefund.models.User;
import com.invoicefund.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collections;

import static com.invoicefund.helpers.Constants.*;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
    private final UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/admin-portal/**").hasRole(ROLE_ADMIN)
                        .requestMatchers("/api/vendor-portal/**").hasRole(ROLE_VENDOR)
                        .requestMatchers("/api/investor-portal/**").hasRole(ROLE_INVESTOR)
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .csrf(csrf -> csrf.disable());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            logger.debug("Attempting to authenticate user: {}", username);
            User user = userRepository.findUserByUsername(username)
                    .orElseThrow(() -> {
                        logger.warn("User not found: {}", username);
                        return new EntityNotFoundException("User", "username", username);
                    });
            logger.debug("User found: {} with role: {}", user.getEmail(), user.getRole().getName());
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    "{noop}" + user.getPasswordHash(),
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName()))
            );
        };
    }
}


























