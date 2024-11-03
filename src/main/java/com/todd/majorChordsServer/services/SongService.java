package com.todd.majorChordsServer.services;

import com.todd.majorChordsServer.dtos.SongDTO;
import com.todd.majorChordsServer.entities.SongEntity;
import com.todd.majorChordsServer.repos.SongRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {

    @Autowired
    private SongRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    public SongDTO saveSong(SongDTO songDTO) {
        SongEntity songEntity = modelMapper.map(songDTO, SongEntity.class);
        SongEntity savedSong = repo.save(songEntity);
        return modelMapper.map(savedSong, SongDTO.class);
    }

    public List<SongDTO> getAllSongs() {
        return repo.findAll()
                .stream()
                .map(songEntity -> modelMapper.map(songEntity, SongDTO.class))
                .collect(Collectors.toList());
    }

    public SongDTO getSongById(String id) {
        return repo.findById(id)
                .map(songEntity -> modelMapper.map(songEntity, SongDTO.class))
                .orElse(null);
    }

    public void deleteSong(String id) {
        repo.deleteById(id);
    }
}
