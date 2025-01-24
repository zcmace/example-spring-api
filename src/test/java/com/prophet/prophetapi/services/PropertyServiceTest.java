package com.prophet.prophetapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.prophet.prophetapi.config.ApplicationProperties;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PropertyServiceTest {

  @Mock
  private ApplicationProperties applicationProperties;

  @InjectMocks
  private PropertyService propertyService;

  @BeforeEach
  void setUp() {
    when(applicationProperties.getExampleHost()).thenReturn("testHost");
    when(applicationProperties.getExamplePort()).thenReturn("testPort");
    when(applicationProperties.getExampleTimeout()).thenReturn("testTimeout");
  }

  @Test
  void testGetAllPropertiesWithSecret() {

    Map<String, String> properties = propertyService.getAllProperties();

    assertEquals("testHost", properties.get("host"));
    assertEquals("testPort", properties.get("port"));
    assertEquals("testTimeout", properties.get("timeout"));
  }
}