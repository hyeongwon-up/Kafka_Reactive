package com.hw.kafkadocker.kafka.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;


@Component
@RequiredArgsConstructor
public class KafkaProducer {
    private static final String TOPIC = "sample";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        System.out.println(" Producer Message : " + message);
    }


}
