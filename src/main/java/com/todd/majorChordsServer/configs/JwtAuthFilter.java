package com.todd.majorChordsServer.configs;

import com.todd.majorChordsServer.entities.UserEntity;
import com.todd.majorChordsServer.services.JwtService;
import com.todd.majorChordsServer.services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final UserService userService;
    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // get token from header
        // use jwtservice to get user id from token
        // use userrepo to fetch user model
        // add it to security context holder

        final String authHeader = request.getHeader("Authorization");
        if(authHeader != null && authHeader.startsWith("Bearer")){
            String token = authHeader.split("Bearer ")[1];
            String userId = jwtService.getUserIdFromToken(token);
            if(userId != null && SecurityContextHolder.getContext().getAuthentication() == null ) {
                UserEntity user = userService.findEntityById(userId).orElse(null);
                if(user != null){
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            user, null, user.getAuthorities()
                    );
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}