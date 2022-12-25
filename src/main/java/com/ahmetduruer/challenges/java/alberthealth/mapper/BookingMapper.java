package com.ahmetduruer.challenges.java.alberthealth.mapper;

import com.ahmetduruer.challenges.java.alberthealth.entity.Booking;
import com.ahmetduruer.challenges.java.alberthealth.entity.Slot;
import com.ahmetduruer.challenges.java.alberthealth.entity.User;
import com.ahmetduruer.challenges.java.alberthealth.error.UserNotFoundException;
import com.ahmetduruer.challenges.java.alberthealth.model.request.BookingDTO;
import com.ahmetduruer.challenges.java.alberthealth.repository.SlotRepository;
import com.ahmetduruer.challenges.java.alberthealth.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BookingMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SlotRepository slotRepository;

    public final Booking toEntity(final BookingDTO dto) {
        final Booking booking = modelMapper.map(dto, Booking.class);
        final UUID userId = dto.getUserId();
        final UUID slotId = dto.getSlotId();
        final User user = userRepository.findById(userId).orElse(null);
        final Slot slot = slotRepository.findById(slotId).orElse(null);

        if (user == null) {
            throw new UserNotFoundException();
        }

        booking.setUser(user);
        booking.setSlot(slot);

        return booking;
    }

    public final BookingDTO toDto(final Booking entity) {
        final BookingDTO dto = modelMapper.map(entity, BookingDTO.class);
        final User user = entity.getUser();
        final Slot slot = entity.getSlot();

        dto.setUserId(user.getId());
        dto.setSlotId(slot.getId());

        return dto;
    }
}