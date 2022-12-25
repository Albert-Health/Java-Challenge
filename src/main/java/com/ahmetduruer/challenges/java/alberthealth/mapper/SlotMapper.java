package com.ahmetduruer.challenges.java.alberthealth.mapper;

import com.ahmetduruer.challenges.java.alberthealth.entity.Slot;
import com.ahmetduruer.challenges.java.alberthealth.entity.User;
import com.ahmetduruer.challenges.java.alberthealth.error.UserNotFoundException;
import com.ahmetduruer.challenges.java.alberthealth.model.request.SlotDTO;
import com.ahmetduruer.challenges.java.alberthealth.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SlotMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private UserRepository userRepository;

    public final Slot toEntity(final SlotDTO dto) {
        final Slot slot = modelMapper.map(dto, Slot.class);
        final UUID userId = dto.getUserId();
        final User user = userRepository.findById(userId).orElse(null);

        if (user == null) {
            throw new UserNotFoundException();
        }

        slot.setUser(user);

        return slot;
    }

    public final SlotDTO toDto(final Slot entity) {
        final SlotDTO dto = modelMapper.map(entity, SlotDTO.class);
        final User user = entity.getUser();

        dto.setUserId(user.getId());

        return dto;
    }
}