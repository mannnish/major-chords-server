package com.todd.majorChordsServer.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Document(collection = "songs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongEntity {

    @Id
    private String id;
    private String title;
    private String album;
    private int year;
    private List<String> artists;
    private List<String> genre;
    private String key;
    private int capo;
    private Set<String> chords;
    private List<SongPart> data;

    @CreatedDate private LocalDateTime createdAt;
    @LastModifiedDate private LocalDateTime updatedAt;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SongPart {
        private String partName;
        private List<LineData> data;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LineData {
        private String line;
        private int lineNumber;
        private List<ChordPosition> chords;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChordPosition {
        private String chord;
        private int position;
    }
}