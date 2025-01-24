package com.prophet.prophetapi.services;

import com.prophet.prophetapi.config.ApplicationProperties;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PropertyService {

  private final ApplicationProperties applicationProperties;

  public PropertyService(ApplicationProperties applicationProperties) {
    this.applicationProperties = applicationProperties;
  }

  public Map<String, String> getAllProperties() {
    return new HashMap<>(Map.of("host", applicationProperties.getExampleHost(),
        "port", applicationProperties.getExamplePort(),
        "timeout", applicationProperties.getExampleTimeout()));
  }
}
