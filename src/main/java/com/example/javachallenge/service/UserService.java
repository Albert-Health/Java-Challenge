package com.example.javachallenge.service;

import com.example.javachallenge.entity.UserEntity;
import com.example.javachallenge.entity.UserSlotEntity;
import com.example.javachallenge.exception.SlotMissingException;
import com.example.javachallenge.exception.UserMissingException;
import com.example.javachallenge.repository.SlotRepository;
import com.example.javachallenge.repository.UserRepository;
import com.example.javachallenge.repository.UserSlotRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final UserSlotRepository userSlotRepository;
    private final SlotRepository slotRepository;

    public UserService(UserRepository userRepository, UserSlotRepository userSlotRepository, SlotRepository slotRepository) {
        this.userRepository = userRepository;
        this.userSlotRepository = userSlotRepository;
        this.slotRepository = slotRepository;
    }

    public List<UserEntity> getAllUsers() {
        return (List)userRepository.findAll();
    }

    public UserSlotEntity createAppointment(Long userId, Long slotId, LocalDateTime localDateTime) {
        var user = userRepository.findById(userId);
        var slot = slotRepository.findById(slotId);

        if (user.isEmpty()) {
            throw new UserMissingException();
        }
        if (slot.isEmpty()) {
            throw new SlotMissingException();
        }
        var entity = new UserSlotEntity();

        entity.setAppointmentTime(localDateTime);
        entity.setUserId(userId);
        entity.setSlotId(slotId);
        var localtime = LocalDateTime.now();
        entity.setReminded(false);
        entity.setCreatedAt(localtime);
        var response = userSlotRepository.save(entity);

        return response;

    }
}
