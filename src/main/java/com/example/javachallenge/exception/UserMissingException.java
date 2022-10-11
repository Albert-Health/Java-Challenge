package com.example.javachallenge.exception;

public class UserMissingException extends RuntimeException{
    public UserMissingException() {
        super("User does not exits");
    }
}
