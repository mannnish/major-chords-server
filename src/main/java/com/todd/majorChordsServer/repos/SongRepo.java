package com.todd.majorChordsServer.repos;

import com.todd.majorChordsServer.entities.SongEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepo extends MongoRepository<SongEntity, String> {

    List<SongEntity> findByArtistsContaining(String artist);
    List<SongEntity> findByTitleContainingIgnoreCase(String title);
    List<SongEntity> findByTitleContainingIgnoreCaseOrArtistsContainingIgnoreCase(String title, String artist);

}
