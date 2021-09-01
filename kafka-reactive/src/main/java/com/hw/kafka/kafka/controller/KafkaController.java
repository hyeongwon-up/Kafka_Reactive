package com.hw.kafka.kafka.controller;

import com.hw.kafka.kafka.domain.Producers;
import com.hw.kafka.kafka.service.KafkaSender;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaSender kafkaSender;
    private final Producers producers;

    @GetMapping
    public String hello(){
        return "Hello Kafka";
    }

    @PostMapping("/producer")
    public String sendMessage(@RequestParam("message") String message) {
        System.out.println("### producer start###");
        kafkaSender.send(message);
        return "success";
    }

    @GetMapping("/receiver")
    public String receiver() {
        producers.sendMessage("kafka-test", "test test test");
        return "success";
    }
}