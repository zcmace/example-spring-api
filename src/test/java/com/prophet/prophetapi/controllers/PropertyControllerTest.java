package com.prophet.prophetapi.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.prophet.prophetapi.services.PropertyService;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PropertyController.class)
public class PropertyControllerTest {

  @MockBean
  private PropertyService propertyService;

  @Autowired
  private MockMvc mockMvc;

  @BeforeEach
  public void setup() {
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