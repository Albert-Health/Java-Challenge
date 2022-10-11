package com.example.javachallenge.controller;

import com.example.javachallenge.model.User;
import com.example.javachallenge.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/user/")
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
}
