package com.hw.kafka.kafka.controller;


import com.hw.kafka.kafka.domain.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaProducer producer;

    @GetMapping
    public String hello(){
        return "Hello Kafka";
    }

    @PostMapping("/producer")
    public String sendMessage(@RequestParam("message") String message) {
        System.out.println("### producer start###");
        producer.sendMessage(message);
        return "success";
    }

}