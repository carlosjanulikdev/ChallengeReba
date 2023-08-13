package com.challenge.reba.exception;

public class ContactInformationNotFoundException extends RuntimeException{

    public ContactInformationNotFoundException(String message){
        super(message);
    }
}
