package com.example.javachallenge.controller;

import com.example.javachallenge.entity.UserEntity;
import com.example.javachallenge.model.User;
import com.example.javachallenge.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user/")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("all")
    public ResponseEntity<List<User>> getAll() {
        var userEntities = userService.getAllUsers();
        var users = userEntities.stream().map(User::toModel).collect(Collectors.toList());
        return ResponseEntity.ok(users);
    }

    @PostMapping("create")
    public ResponseEntity<String> createSlot(
            @RequestParam(value = "userId") String userId,
            @RequestParam(value = "slotId") String slotId,
            @RequestParam(value = "date") String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        var localDateTime = LocalDateTime.parse(date, formatter);
        var response = userService.createAppointment(Long.valueOf(userId), Long.valueOf(slotId), localDateTime);
        var appointmentTime = response.getAppointmentTime();
        return ResponseEntity.ok("You have an appointment at " + appointmentTime.format(formatter));
    }
}
