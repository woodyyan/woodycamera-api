package com.woody.woodycameraapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ErrorException extends RuntimeException {
    private HttpStatus status;
    private Error error;
}
