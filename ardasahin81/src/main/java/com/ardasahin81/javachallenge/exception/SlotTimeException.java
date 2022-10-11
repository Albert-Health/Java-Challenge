package com.ardasahin81.javachallenge.exception;

public class SlotTimeException extends RuntimeException {

    public SlotTimeException() {
        super("Slot's end time is not after its start time.");
    }

}
