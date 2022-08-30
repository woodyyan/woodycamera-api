package com.woody.woodycameraapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class GlobalControllerAdvice {

    @ResponseBody
    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<Error> handleException(ErrorException e) {
        log.error(e.getError().getTitle(), e);
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
