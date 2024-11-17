package com.todd.majorChordsServer.configs;

import com.todd.majorChordsServer.entities.RolesEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SpringSecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        String[] publicEndpoints = new String[]{
                "/swagger-ui/**", "/v", "/v3/api-docs/**"
        };
        httpSecurity.authorizeHttpRequests( (auth) -> auth
                        .requestMatchers(publicEndpoints).permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/songs/**").hasRole(RolesEnum.ADMIN.name())
                        .requestMatchers("/songs/**").permitAll()
                        .requestMatchers( "/auth/**").permitAll()
                        .requestMatchers("/admin/**").hasRole(RolesEnum.ADMIN.name())
                        .anyRequest().authenticated())
                .csrf(csrf -> csrf.disable())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement((sessionConfig) ->
                        sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );
        // No login form is being used
        // session management is also disabled
        // login route added to exclusion group
        // added jwt auth filter
        return httpSecurity.build();
    }
}
