package com.prophet.prophetapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor(staticName = "getInstance")
@AllArgsConstructor
public class Car {

    @JsonIgnore
    private Long id;

    private String make;
    private String model;
    private int year;
    private String color;

}
