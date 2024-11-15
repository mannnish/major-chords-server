package com.todd.majorChordsServer.services;

import com.todd.majorChordsServer.dtos.UserSignUpDTO;
import com.todd.majorChordsServer.dtos.UserTokenDTO;
import com.todd.majorChordsServer.entities.RolesEnum;
import com.todd.majorChordsServer.entities.UserEntity;
import com.todd.majorChordsServer.repos.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthService {

    @Autowired
    private UserRepo repo;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private AuthenticationManager authManager;
    @Autowired private JwtService jwtService;
    @Autowired private ModelMapper mapper;

    public void signUpUser(UserSignUpDTO userSignUpDTO) throws Exception {
        UserEntity user = repo.findUserByUsername(userSignUpDTO.getUsername()).orElse(null);
        if (user != null)
            throw new Exception("user with same username already exists");
        String hashedPassword = passwordEncoder.encode(userSignUpDTO.getPassword());
        UserEntity entity = mapper.map(userSignUpDTO, UserEntity.class);
        entity.setPassword(hashedPassword);
        // Adding default role
        Set<RolesEnum> rolesEnumSet = new HashSet<>();
        rolesEnumSet.add(RolesEnum.VIEWER);
        entity.setRoles(rolesEnumSet);
        repo.save(entity);
    }

    public UserTokenDTO login(UserSignUpDTO userSignUpDTO) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(userSignUpDTO.getUsername(), userSignUpDTO.getPassword())
        );

        UserEntity user = (UserEntity) authentication.getPrincipal();
        String token = jwtService.generateToken(user);
        System.out.println("got user " + user.getUsername() + " with token: " + token);
        return UserTokenDTO.builder().token(token).build();
    }
}
