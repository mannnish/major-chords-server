package com.todd.majorChordsServer.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginDTO {
    @NotNull private String username;
    @NotNull private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

