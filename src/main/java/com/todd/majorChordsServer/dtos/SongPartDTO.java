package com.todd.majorChordsServer.dtos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongPartDTO {
    private String partName;
    private List<LineDataDTO> data;
}
