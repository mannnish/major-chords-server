package com.todd.majorChordsServer.dtos;

import com.todd.majorChordsServer.entities.RolesEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOutputDTO {

    private String id;
    private String username;
    private String name;
    private String guitarLevel;
    private Set<RolesEnum> roles;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
