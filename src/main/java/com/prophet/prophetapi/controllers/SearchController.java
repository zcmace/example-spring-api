package com.prophet.prophetapi.controllers;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prophet.prophetapi.model.Car;
import com.prophet.prophetapi.services.CarService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/search")
@Validated
@Slf4j
@RequiredArgsConstructor()
class SearchController {
    
    @Autowired
    private final CarService carService;
    
    @Autowired
    private final ObjectMapper jsonObjectMapper;


    @GetMapping()
    @ResponseBody
    public ResponseEntity<String> SearchAll() {
        log.info("Search all request received");
        return new ResponseEntity<String>(" { Status: Ok, Message: 'How are you?' }", HttpStatus.OK);
    }

    @GetMapping("/multiply/{number}")
    @ResponseBody
    public ResponseEntity<String> Multiply(@PathVariable("number") @NotBlank String number) {
        Long result = Long.parseLong(number);
        if (result.toString().length() <= 4) {
            result = result * result;
            return new ResponseEntity<String>(
                    String.format("{ Status: OK, Message: '%s squared is %s' }", number, result), HttpStatus.OK);
        } else
            return new ResponseEntity<String>(
                    "ERROR: Please pass a number that 4 digits or less for performance reasons",
                    HttpStatus.BAD_REQUEST);

    }

    @GetMapping("/cars")
    @ResponseBody
    public ResponseEntity<String> SearchAllCars() throws JsonProcessingException {

        List<Car> carList = carService.GetAllCars();
        log.info("Received request for 'SearchAllCars' endpoint");
        return new ResponseEntity<String>(jsonObjectMapper.writeValueAsString(carList), HttpStatus.OK);

    }

}