package com.hw.kafka.kafka.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class Consumers {

    @KafkaListener(topics = "kafka-test", groupId = "myGroup")
    public void listenGroup(String message) {
        System.out.println("Recieved Message : " + message);
    }
}
