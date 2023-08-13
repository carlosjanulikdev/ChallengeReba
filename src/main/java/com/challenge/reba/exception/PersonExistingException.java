package com.challenge.reba.exception;

public class PersonExistingException extends RuntimeException{

    public PersonExistingException(String message){
        super(message);
    }
}
