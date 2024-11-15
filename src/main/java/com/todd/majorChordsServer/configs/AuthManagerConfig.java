package com.todd.majorChordsServer.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Configuration
public class AuthManagerConfig {
    @Bean
    AuthenticationManager getAuthManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }
}