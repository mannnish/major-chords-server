package com.todd.majorChordsServer.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSignUpDTO {

    @NotNull(message = "username cannot be null")
    @NotEmpty(message = "username cannot be empty")
    @Size(min = 3, message = "username min size of 3")
    @Size(max = 16, message = "username max size of 16")
    private String username;

    @NotNull(message = "password cannot be null")
    @NotEmpty(message = "password cannot be empty")
    @Size(min = 5, message = "password min size of 5")
    @Size(max = 30, message = "password max size of 30")
    private String password;

    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "name cannot be empty")
    @Size(min = 3, message = "name min size of 3")
    @Size(max = 16, message = "name max size of 16")
    private String name;

    private String guitarLevel;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
