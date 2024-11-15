package com.todd.majorChordsServer.services;

import com.todd.majorChordsServer.dtos.UserOutputDTO;
import com.todd.majorChordsServer.dtos.UserSignUpDTO;
import com.todd.majorChordsServer.entities.UserEntity;
import com.todd.majorChordsServer.repos.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired private UserRepo repo;
    @Autowired private ModelMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findUserByUsername(username).orElse(null);
    }

    public Optional<UserEntity> findEntityById(String id){
        return repo.findById(id);
    }

    public UserOutputDTO getMe(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserEntity userEntity) {
            return mapper.map(userEntity, UserOutputDTO.class);
        } else return null;
    }
}
