package com.todd.majorChordsServer.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChordPositionDTO {
    private String chord;
    private int position;
}
