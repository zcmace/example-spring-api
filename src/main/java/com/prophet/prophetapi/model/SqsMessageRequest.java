package com.prophet.prophetapi.model;

import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SqsMessageRequest {

  @NotEmpty
  private String message;
}
