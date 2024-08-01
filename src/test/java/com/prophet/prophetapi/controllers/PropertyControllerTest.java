package com.prophet.prophetapi.controllers;

import com.prophet.prophetapi.services.PropertyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

    @Mock
    private PropertyService propertyService;

    @InjectMocks
    private PropertyController propertyController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(propertyController).build();

        Map<String, String> properties = new HashMap<>();
        properties.put("key", "value");

        when(propertyService.getAllProperties()).thenReturn(properties);
    }

    @Test
    public void testGetProperties() throws Exception {
        mockMvc.perform(get("/property")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"key\":\"value\"}"));
    }

}