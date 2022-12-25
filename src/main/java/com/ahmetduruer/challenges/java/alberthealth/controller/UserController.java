package com.ahmetduruer.challenges.java.alberthealth.controller;

import com.ahmetduruer.challenges.java.alberthealth.entity.User;
import com.ahmetduruer.challenges.java.alberthealth.model.request.UserDtO;
import com.ahmetduruer.challenges.java.alberthealth.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private UserService userService;

    @GetMapping
    final List<User> all() {
        return userService.findAll();
    }

    @PostMapping
    final UserDtO newUser(final @RequestBody UserDtO userDto) {
        final User createdUser = userService.newUser(convertToEntity(userDto));

        return convertToDto(createdUser);
    }

    @GetMapping("/{id}")
    final UserDtO getById(final @PathVariable UUID id) {
        return convertToDto(userService.getById(id));
    }

    private UserDtO convertToDto(final User user) {
        return modelMapper.map(user, UserDtO.class);
    }

    private User convertToEntity(final UserDtO userDto) {
        return modelMapper.map(userDto, User.class);
    }
}
