package com.example.javachallenge.controller;

import com.example.javachallenge.entity.UserEntity;
import com.example.javachallenge.entity.UserSlotEntity;
import com.example.javachallenge.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void getAllUsersEmptyTest() throws Exception {

        when(userService.getAllUsers()).thenReturn(List.of());


        mockMvc
                .perform(get("/user/all"))
                .andExpect(content().json("[]"))
                .andExpect(status().isOk());
    }

    @Test
    void getAllUsersTest() throws Exception {

        List<UserEntity> entities = new ArrayList<>();

        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setUsername("Jimi");
        userEntity.setEmail("jimi@com");
        userEntity.setCreatedAt(LocalDateTime.MIN);
        entities.add(userEntity);

        when(userService.getAllUsers()).thenReturn(entities);


        mockMvc
                .perform(get("/user/all"))
                .andExpect(content().json("[{\"username\":\"Jimi\",\"email\":\"jimi@com\",\"id\":1}]"))
                .andExpect(status().isOk());
    }

    @Test
    void createSlotTest() throws Exception{
        String targetDate = "11.10.2022 22:22";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        UserSlotEntity entity = new UserSlotEntity();
        entity.setUserId(2L);
        entity.setSlotId(3L);
        entity.setReminded(false);
        var localDateTime = LocalDateTime.parse(targetDate, formatter);
        entity.setAppointmentTime(localDateTime);

        when(userService.createAppointment(any(), any(), any())).thenReturn(entity);
        mockMvc
                .perform(post("/user/create?userId=2&slotId=3&date="+targetDate))
                .andExpect(content().string("You have an appointment at "+targetDate))
                .andExpect(status().isOk());
        verify(userService).createAppointment(2L, 3L, localDateTime);
    }
}