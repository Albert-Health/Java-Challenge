package com.ardasahin81.javachallenge.exception;

public class SlotSelfBookException extends RuntimeException {

    public SlotSelfBookException() {
        super("Slot tried to be booked by its owner.");
    }

}
