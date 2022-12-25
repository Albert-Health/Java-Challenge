package com.ahmetduruer.challenges.java.alberthealth.service;

import com.ahmetduruer.challenges.java.alberthealth.entity.User;
import com.ahmetduruer.challenges.java.alberthealth.error.UserNotFoundException;
import com.ahmetduruer.challenges.java.alberthealth.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public final class UserService {
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), true)
                .collect(Collectors.toList());
    }

    public User newUser(final User user) {
        return userRepository.save(user);
    }

    public User getById(final UUID id) {
        final Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }

        return user.get();
    }
}
