package com.example.springbootsample.services;

public interface MessageService {

    void sendMessageToKafka(String topic, String key, String message);

    void receiveMessage(String key, String message);
}
