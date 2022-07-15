package com.prophet.prophetapi.controllers;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.*;


@RestController
@RequestMapping("/search")
@Validated
class Search {

    @GetMapping()
    @ResponseBody
    public String SearchAll(){
        return "Hello";
    }

    @GetMapping("/multiply/{number}")
    @ResponseBody
    public String Multiply(@PathVariable("number") @DecimalMax(value = "10", message = "please enter a number with a maximum of 10 digits") @NotBlank String number){
        Long result = Long.parseLong(number);
        return String.format("%d", result*result);


    }

}