package com.todd.majorChordsServer.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO {

    private String id;
    @NotNull(message = "title must not be null")
    @Size(min = 2, max = 30)
    private String title;

    private String album;
    private int year;
    private List<String> artists;
    private List<String> genre;
    private String key;
    private List<SongPartDTO> data;
    private List<String> chords;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}