package com.todd.majorChordsServer.repos;

import com.todd.majorChordsServer.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<UserEntity, String> {

    Optional<UserEntity> findUserByUsername(String username);

}
