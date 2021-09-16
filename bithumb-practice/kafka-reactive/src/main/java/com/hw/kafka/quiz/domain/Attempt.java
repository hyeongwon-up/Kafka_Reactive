package com.hw.kafka.quiz.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;

@Getter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode @Document(collection = "attempts")
public class Attempt implements Serializable {

    @Id
    private long id;
    private final User user;
    private final Quiz quiz;
    private final int resultAttempt;
    private final boolean correct;
}
