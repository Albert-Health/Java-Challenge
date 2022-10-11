package com.example.javachallenge.service;

import com.example.javachallenge.entity.UserEntity;
import com.example.javachallenge.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {
        return (List)userRepository.findAll();
    }
}
