package com.ardasahin81.javachallenge.exception;

public class SlotBookException extends RuntimeException {

    public SlotBookException() {
        super("Slot already booked.");
    }

}
