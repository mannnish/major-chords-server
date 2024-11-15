package com.todd.majorChordsServer.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOutputDTO {

    private String id;
    private String username;
    private String name;
    private String guitarLevel;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
