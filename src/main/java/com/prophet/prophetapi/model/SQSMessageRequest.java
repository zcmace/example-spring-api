package com.prophet.prophetapi.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class SQSMessageRequest {
    @NotEmpty
    private String message;
}
