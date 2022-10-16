package com.example.javachallenge.controller;

import com.example.javachallenge.model.Slot;
import com.example.javachallenge.service.SlotService;
import com.example.javachallenge.util.SlotParameters;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SlotController {

    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @GetMapping("/findAvailableSlots")
    public ResponseEntity<List<Slot>> findAvailableSlots(@RequestParam @NotBlank String user) {
        return new ResponseEntity<>(slotService.findAvailableSlots(user), HttpStatus.OK);
    }

    @PostMapping("/createSlots")
    public ResponseEntity<Slot> create(@Valid @RequestBody SlotParameters parameters) {
        if (slotService.createSlots(parameters))
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PostMapping("/bookSlot")
    public ResponseEntity<Slot> bookSlot(@RequestParam @NotNull Long slotId, @RequestParam @NotBlank String booker) {
        if (slotService.bookSlot(slotId, booker))
            return new ResponseEntity<>(HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
