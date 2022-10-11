package com.example.javachallenge.controller;

import com.example.javachallenge.model.User;
import com.example.javachallenge.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user/")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("greeting")
    public ResponseEntity greeting() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("all")
    public ResponseEntity getAll() {
        var userEntities = userService.getAllUsers();
        var users = userEntities.stream().map(User::toModel).collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @PostMapping("create")
    public ResponseEntity createSlot(@RequestParam(value = "userId") String userId, @RequestParam(value = "slotId") String slotId) {

        var response = userService.createAppointment(Long.valueOf(userId), Long.valueOf(slotId));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        var date = response.getAppointmentTime();
        return ResponseEntity.ok("You have an appointment at " + date.format(formatter) + ", \nIt's in 15 minutes");
    }
}
