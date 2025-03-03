package com.prophet.prophetapi.config;

import com.prophet.prophetapi.exception.ContentNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, Object>> handleValidationExceptions(
      MethodArgumentNotValidException ex) {

    Map<String, Object> body = new HashMap<>();
    List<String> errors = new ArrayList<>();

    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = String.format("%s %s", fieldName, error.getDefaultMessage());
      errors.add(errorMessage);
    });

    body.put("status", HttpStatus.BAD_REQUEST.value());
    body.put("errors", errors);

    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ContentNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Map<String, String>> handleContentNotFoundException(ContentNotFoundException e) {
    Map<String, String> response = new HashMap<>();
    response.put("error", "Content Not Found");
    response.put("message", e.getMessage());
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }
}