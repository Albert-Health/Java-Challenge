package com.ardasahin81.javachallenge.exception;

public class SlotConflictException extends RuntimeException {

    public SlotConflictException() {
        super("Slot conflicted.");
    }

}
