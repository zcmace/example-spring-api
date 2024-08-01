package com.prophet.prophetapi.controllers;

import com.prophet.prophetapi.model.SQSMessageRequest;
import com.prophet.prophetapi.services.SQSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/messages")
public class SQSController {

    private final SQSService sqsService;

    public SQSController(SQSService sqsService) {
        this.sqsService = sqsService;
    }

    @PostMapping
    private ResponseEntity<String> sendMessage(@Valid @RequestBody SQSMessageRequest sqsMessageRequest) {
        return sqsService.sendMessage(sqsMessageRequest.getMessage());
    }

    @GetMapping("/{count}")
    private ResponseEntity<List<String>> receiveMessage(@PathVariable @Max(10) @Min(1) Integer count) {
        List<String> sqsResponse = sqsService.receiveMessage(count);
        return ResponseEntity.ok(sqsResponse);
    }

}
