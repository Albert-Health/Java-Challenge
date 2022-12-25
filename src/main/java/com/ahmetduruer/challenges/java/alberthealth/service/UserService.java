package com.ahmetduruer.challenges.java.alberthealth.service;

import com.ahmetduruer.challenges.java.alberthealth.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public final class UserService {
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
