package com.challenge.reba.exception;

public class CountryNotFoundException extends RuntimeException{

    public CountryNotFoundException(String message){
        super(message);
    }
}
