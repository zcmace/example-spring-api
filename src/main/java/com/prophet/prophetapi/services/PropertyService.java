package com.prophet.prophetapi.services;

import com.prophet.prophetapi.config.ApplicationProperties;
import com.prophet.prophetapi.config.SecretProperties;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PropertyService {

  private final ApplicationProperties applicationProperties;
  private final SecretProperties secretProperties;

  public PropertyService(ApplicationProperties applicationProperties, SecretProperties secretProperties) {
    this.applicationProperties = applicationProperties;
    this.secretProperties = secretProperties;
  }

  public Map<String, String> getAllProperties() {
    Map<String, String> propertyMap = new java.util.HashMap<>(Map.of("host", applicationProperties.getExampleHost(),
        "port", applicationProperties.getExamplePort(),
        "timeout", applicationProperties.getExampleTimeout()));
    if (StringUtils.isNotBlank(secretProperties.getProperty())) {
      propertyMap.put("secret_property", secretProperties.getProperty());
    }
    return propertyMap;
  }
}
