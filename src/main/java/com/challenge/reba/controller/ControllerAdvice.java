package com.challenge.reba.controller;

import com.challenge.reba.dto.ErrorDTO;
import com.challenge.reba.exception.ContactInformationNotFoundException;
import com.challenge.reba.exception.CountryNotFoundException;
import com.challenge.reba.exception.DocumentTypeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
}
