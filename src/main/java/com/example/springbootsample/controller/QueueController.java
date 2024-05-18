package com.example.springbootsample.controller;

import com.example.springbootsample.services.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class QueueController {

    private final MessageService messageService;

    @Operation(summary = "Send message to kafka server")
    @GetMapping("/send")
    public ResponseEntity<?> sendMessage(@RequestParam(value = "topic", defaultValue = "app") String topic,
                                         @RequestParam("key") String key,
                                         @RequestParam("message") String message) {
        messageService.sendMessageToKafka(topic, key, message);
        return ResponseEntity.ok(1);
    }
}
