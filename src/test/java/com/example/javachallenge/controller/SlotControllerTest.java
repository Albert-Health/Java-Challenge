package com.example.javachallenge.controller;

import com.example.javachallenge.entity.SlotEntity;
import com.example.javachallenge.service.SlotService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SlotController.class)
class SlotControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SlotService slotService;

    @Test
    void getAllSlotsEmpty() throws Exception{

        when(slotService.getAllSlots()).thenReturn(List.of());

        mockMvc
                .perform(get("/slot/all"))
                .andExpect(content().json("[]"))
                .andExpect(status().isOk());
    }
    @Test
    void getAllSlots() throws Exception{

        List<SlotEntity> entities = new ArrayList<>();
        SlotEntity entity = new SlotEntity();
        entity.setUserId(2L);
        entity.setDescription("Lorem ipsum");
        entity.setCreatedAt(LocalDateTime.now());
        entities.add(entity);

        when(slotService.getAllSlots()).thenReturn(entities);

        mockMvc
                .perform(get("/slot/all"))
                .andExpect(content().json("[{\"id\":null,\"userId\":2,\"description\":\"Lorem ipsum\"}]"))
                .andExpect(status().isOk());
    }
}