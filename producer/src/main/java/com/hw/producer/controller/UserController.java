package com.hw.producer.controller;


import com.hw.producer.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "kafka-spring-producer";

    @PostMapping("/publish/{name}")
    public String postMessage(@PathVariable final String name) {
        User user = new User();
        user.setId("lee");
        user.setName("hihi");
        user.setEmail("asdl@test.com");

        kafkaTemplate.send(TOPIC, user);
        return "Message Published Success";
    }


}
