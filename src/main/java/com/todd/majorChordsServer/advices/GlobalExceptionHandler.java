package com.todd.majorChordsServer.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ApiError> validationError(MethodArgumentNotValidException e){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ApiError apiError = ApiError.builder()
                .statusCode(status.value())
                .statusMessage(e.getClass().getSimpleName() + ": " + status.getReasonPhrase())
                .errorMessage("Input validation Error")
                .subErrors(
                        e.getAllErrors().stream().map(
                                subError -> subError.getDefaultMessage()
                        ).toList()
                )
                .build();
        return new ResponseEntity<>(apiError, status);
    }

    @ExceptionHandler(Exception.class)
    ResponseEntity<ApiError> baseException(Exception e){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiError apiError = ApiError.builder()
                .statusCode(status.value())
                .statusMessage(e.getClass().getSimpleName() + ": " + status.getReasonPhrase())
                .errorMessage(e.getMessage())
                .subErrors(null)
                .build();
        return new ResponseEntity<>(apiError, status);
    }

}
