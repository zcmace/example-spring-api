package com.prophet.prophetapi.controllers;

import com.prophet.prophetapi.model.SqsMessageRequest;
import com.prophet.prophetapi.services.SqsService;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class SqsController {

  private final SqsService sqsService;

  public SqsController(SqsService sqsService) {
    this.sqsService = sqsService;
  }

  @PostMapping
  private ResponseEntity<String> sendMessage(@Valid @RequestBody SqsMessageRequest sqsMessageRequest) {
    return sqsService.sendMessage(sqsMessageRequest.getMessage());
  }

  @GetMapping("/{count}")
  private ResponseEntity<List<String>> receiveMessage(@PathVariable @Max(10) @Min(1) Integer count) {
    List<String> sqsResponse = sqsService.receiveMessage(count);
    return ResponseEntity.ok(sqsResponse);
  }
}
