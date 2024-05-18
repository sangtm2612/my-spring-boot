package com.example.springbootsample.services.impl;

import com.example.springbootsample.entities.Message;
import com.example.springbootsample.repositories.MessageRepository;
import com.example.springbootsample.services.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final MessageRepository messageRepository;

    @Override
    public void sendMessageToKafka(String topic, String key, String message) {
        kafkaTemplate.send(topic, key, message);
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "app", partitions = { "0"}))
    @Override
    public void receiveMessage(@Header(KafkaHeaders.RECEIVED_KEY) String key, @Payload String message) {
        log.info("[Application Receive Message From Kafka] :: key={}, value={});", key, message);
        Message obj = new Message();
        obj.setKey(key);
        obj.setValue(message);
        obj.setUserCreated("system");
        obj.setUserUpdated("system");
        obj.setCreatedDate(LocalDateTime.now());
        obj.setUpdatedDate(LocalDateTime.now());
        messageRepository.save(obj);
    }
}
