package com.prophet.prophetapi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonWebConfig {

  @Bean
  public ObjectMapper jsonMapping() {
    return new Jackson2ObjectMapperBuilder()
        .indentOutput(true)
        .propertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE)
        .build();
  }
}