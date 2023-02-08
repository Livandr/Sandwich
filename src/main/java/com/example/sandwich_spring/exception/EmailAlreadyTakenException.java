package com.example.sandwich_spring.exception;

public class EmailAlreadyTakenException extends RuntimeException{

    public EmailAlreadyTakenException(){
        super("the specified mail is already taken");
    }
}
