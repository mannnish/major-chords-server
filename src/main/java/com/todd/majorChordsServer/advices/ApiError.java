package com.todd.majorChordsServer.advices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
    private int statusCode;
    private String statusMessage;
    private String errorMessage;
    private List<String> subErrors;
}
