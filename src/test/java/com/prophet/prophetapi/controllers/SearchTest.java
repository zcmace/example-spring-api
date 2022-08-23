package com.prophet.prophetapi.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.prophet.prophetapi.model.Car;
import com.prophet.prophetapi.services.CarService;

@SpringBootTest
public class SearchTest {
    
    private SearchController searchController;

    private ObjectMapper jsonObjectMapper;

    @Mock
    public CarService carService;

    @BeforeEach
    void init() {
        jsonObjectMapper  = new Jackson2ObjectMapperBuilder()
        .indentOutput(true)
        .propertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE)    
        .build();
        searchController = new SearchController(carService, jsonObjectMapper);
    }

    @Test
    void whenSearchAllCars_ThenReturnResponse() throws JsonProcessingException{
        
        List<Car> carList = BuildCarList();

        when(carService.GetAllCars()).thenReturn(BuildCarList());

        ResponseEntity<String> expected = new ResponseEntity<String>(jsonObjectMapper.writeValueAsString(carList), HttpStatus.OK);
        ResponseEntity<String> actual = searchController.SearchAllCars();
        
       verify(carService).GetAllCars();
        assertEquals(expected, actual);
    }

    List<Car> BuildCarList() {

        List<Car> result = new ArrayList<Car>();
        result.add(new Car(2L, "Dodge", "Charger", 2014, "Silver"));
        result.add(new Car(3L, "Ford", "F-150", 2022, "White"));
        result.add(new Car(4L, "Toyota", "Tacoma", 2006, "Red"));
        result.add(new Car(5L, "BMW", "5 Series", 2018, "Blue"));

        return result;
    }

}
