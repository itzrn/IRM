package com.darknerd.quizapp.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationErrors(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(ex.getMessage()+"\n\nPLEASE PROVIDE THE FIELD IN CORRECT FROM", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDuplicateKey(DataIntegrityViolationException ex){
        return new ResponseEntity<>(ex.getMessage() + "\n\nPLEASE PROVIDE NEW QUESTION IN PROVIDED CATEGORY", HttpStatus.CONFLICT);
    }
}
