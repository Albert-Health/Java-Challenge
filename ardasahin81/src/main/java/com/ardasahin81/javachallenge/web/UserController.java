package com.ardasahin81.javachallenge.web;

import com.ardasahin81.javachallenge.domain.User;
import com.ardasahin81.javachallenge.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/detail")
    public User get(@RequestParam Long id) {
        return userService.get(id);
    }
}
