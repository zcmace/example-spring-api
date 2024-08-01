package com.prophet.prophetapi.services;

import com.prophet.prophetapi.config.ApplicationProperties;
import com.prophet.prophetapi.config.SecretProperties;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PropertyServiceTest {

    @Mock
    private ApplicationProperties applicationProperties;

    @Mock
    private SecretProperties secretProperties;

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
        when(secretProperties.getProperty()).thenReturn("secretProperty");

        Map<String, String> properties = propertyService.getAllProperties();

        assertEquals("testHost", properties.get("host"));
        assertEquals("testPort", properties.get("port"));
        assertEquals("testTimeout", properties.get("timeout"));
        assertEquals("secretProperty", properties.get("secret_property"));
    }

    @Test
    void testGetAllPropertiesWithoutSecret() {
        when(secretProperties.getProperty()).thenReturn("");

        Map<String, String> properties = propertyService.getAllProperties();

        assertEquals("testHost", properties.get("host"));
        assertEquals("testPort", properties.get("port"));
        assertEquals("testTimeout", properties.get("timeout"));
        assertNull(properties.get("secret_property"));
    }

}