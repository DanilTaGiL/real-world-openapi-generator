package com.example.backend.config;

import com.example.backend.dto.Response;
import com.example.backend.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@ControllerAdvice
@RestController
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<?>> handleException(Exception e) {
        log.error("Application exception", e);
        return new ResponseEntity<>(
                Response.error(500, "Application exception:\n" + e.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<Response<?>> objNotFoundException(Exception e) {
        log.error("Application exception", e);
        return new ResponseEntity<>(
                Response.error(404, e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }
}
