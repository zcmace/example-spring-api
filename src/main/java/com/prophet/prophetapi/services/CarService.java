package com.prophet.prophetapi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prophet.prophetapi.model.Car;

@Service
public class CarService {
        public List<Car> GetAllCars() {
            List<Car> list = new ArrayList<Car>();
            
            list.add(new Car(1L, "Toyota", "Camry", 2017, "Blue"));
            list.add(new Car(2L, "Dodge", "Charger", 2014, "Silver"));
            list.add(new Car(3L, "Ford", "F-150", 2022, "White"));
            list.add(new Car(4L, "Toyota", "Tacoma", 2006, "Red"));
            list.add(new Car(5L, "BMW", "5 Series", 2018, "Blue"));
            
            return list;

        }
}
