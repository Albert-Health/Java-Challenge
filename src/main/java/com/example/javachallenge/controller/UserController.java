package com.example.javachallenge.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/book/")
public class UserController {
    @GetMapping("greeting")
    public ResponseEntity greeting() {
        return ResponseEntity.ok("Hello World");
    }
}
