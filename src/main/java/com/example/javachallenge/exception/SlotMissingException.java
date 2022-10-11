package com.example.javachallenge.exception;

public class SlotMissingException extends RuntimeException{
    public SlotMissingException() {
        super("Slot does not exist");
    }
}
