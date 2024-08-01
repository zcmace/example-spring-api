package com.prophet.prophetapi.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.*;

import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SQSService {
    private final SqsClient sqsClient;

    @Value("${sqs.queue.url}")
    private String queueUrl;

    public SQSService() {
        // Initializes SQS client
        this.sqsClient = SqsClient.builder().region(Region.US_EAST_2).build();

    }

    public ResponseEntity<String> sendMessage(String message) {
        log.debug(message);
        SendMessageRequest sendMsgRequest = SendMessageRequest.builder()
                .queueUrl(queueUrl)
                .messageBody(message)
                .delaySeconds(5)
                .build();

        SendMessageResponse response = sqsClient.sendMessage(sendMsgRequest);
        log.info(response.messageId());
        return new ResponseEntity<>("Successfully created message with id " + response.messageId(), HttpStatus.OK);
    }

    public List<String> receiveMessage(Integer count) {
        ReceiveMessageRequest receiveRequest = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .maxNumberOfMessages(count)
                .build();

        var receiveResponse = sqsClient.receiveMessage(receiveRequest);

        if (receiveResponse.messages().isEmpty()) {
            System.out.println("No messages received.");
        } else {
            List<String> messages = receiveResponse.messages().stream()
                    .map(message -> {
                        String messageId = message.messageId();
                        String body = message.body();

                        // Delete the message from the SQS queue.
                        DeleteMessageRequest deleteRequest = DeleteMessageRequest.builder()
                                .queueUrl(queueUrl)
                                .receiptHandle(message.receiptHandle())
                                .build();
                        sqsClient.deleteMessage(deleteRequest);

                        return "ID: " + messageId + " Message: " + body;
                    })
                    .collect(Collectors.toList());

            messages.forEach(System.out::println);
            return messages;
        }

        return List.of();
    }

}