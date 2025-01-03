package com.prophet.prophetapi.controllers;

import com.prophet.prophetapi.services.PropertyService;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/property")
public class PropertyController {

  private final PropertyService propertyService;

  public PropertyController(PropertyService propertyService) {
    this.propertyService = propertyService;
  }

  @GetMapping()
  private Map<String, String> getProperties() {
    return propertyService.getAllProperties();
  }
}
