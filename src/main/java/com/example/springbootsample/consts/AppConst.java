package com.example.springbootsample.consts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConst {

    @Value("${spring.kafka.bootstrap-servers}")
    public String bootstrapServer;

    @Value("${spring.kafka.consumer.group-id}")
    public String groupIdConsumer;
}
