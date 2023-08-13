package com.challenge.reba.controller;

import com.challenge.reba.dto.ErrorDTO;
import com.challenge.reba.exception.ContactInformationNotFoundException;
import com.challenge.reba.exception.CountryNotFoundException;
import com.challenge.reba.exception.DocumentTypeNotFoundException;
import com.challenge.reba.exception.PersonExistingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = ContactInformationNotFoundException.class)
    public ResponseEntity<ErrorDTO> contactInformationNotFoundExceptionHandler(ContactInformationNotFoundException e){
        ErrorDTO errorDTO = ErrorDTO.builder()
                .code("P-001")
                .message(e.getMessage())
                .build();

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = DocumentTypeNotFoundException.class)
    public ResponseEntity<ErrorDTO> documentTypeNotFoundExceptionHandler(DocumentTypeNotFoundException e){
        ErrorDTO errorDTO = ErrorDTO.builder()
                            .code("P-002")
                            .message(e.getMessage())
                            .build();

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = CountryNotFoundException.class)
    public ResponseEntity<ErrorDTO> countryNotFoundExceptionHandler(CountryNotFoundException e){
        ErrorDTO errorDTO = ErrorDTO.builder()
                .code("P-003")
                .message(e.getMessage())
                .build();

        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = PersonExistingException.class)
    public ResponseEntity<ErrorDTO> personExistingExceptionHandler(PersonExistingException e){
        ErrorDTO errorDTO = ErrorDTO.builder()
                .code("P-004")
                .message(e.getMessage())
                .build();

        return new ResponseEntity<>(errorDTO, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> argumentsNotValidHandler(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
