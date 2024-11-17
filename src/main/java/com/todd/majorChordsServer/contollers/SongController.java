package com.todd.majorChordsServer.contollers;
import com.todd.majorChordsServer.dtos.SongDTO;
import com.todd.majorChordsServer.services.SongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @PostMapping
    public ResponseEntity<SongDTO> addSong(@RequestBody @Valid SongDTO songDTO) {
        SongDTO savedSong = songService.saveSong(songDTO);
        return ResponseEntity.ok(savedSong);
    }

    @GetMapping
    public ResponseEntity<List<SongDTO>> getAllSongs() {
        List<SongDTO> songs = songService.getAllSongs();
        return ResponseEntity.ok(songs);
    }

    @GetMapping(path = "/search")
    public ResponseEntity<List<SongDTO>> searchSong(
            @RequestParam(required = true) String query
    ){
        return new ResponseEntity<>(songService.searchSong(query), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SongDTO> getSongById(@PathVariable String id) {
        SongDTO song = songService.getSongById(id);
        return song != null ? ResponseEntity.ok(song) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable String id) {
        songService.deleteSong(id);
        return ResponseEntity.noContent().build();
    }
}
