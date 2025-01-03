package com.prophet.prophetapi.services;

import com.prophet.prophetapi.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    private CarService carService;

    @BeforeEach
    void setUp() {
        carService = new CarService();
    }

    @Test
    void getAllCars() {
        List<Car> cars = carService.getAllCars();

        // Assert the size of the list is 5
        assertEquals(5, cars.size());

    }
}