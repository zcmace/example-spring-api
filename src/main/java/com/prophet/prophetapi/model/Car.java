package com.prophet.prophetapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Car {

  private Long id;
  private String make;
  private String model;
  private int year;
  private String color;
}
