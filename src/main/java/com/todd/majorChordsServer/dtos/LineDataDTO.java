package com.todd.majorChordsServer.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineDataDTO {
    private int lineNumber;
    private String line;
    private List<ChordPositionDTO> chords;
}
