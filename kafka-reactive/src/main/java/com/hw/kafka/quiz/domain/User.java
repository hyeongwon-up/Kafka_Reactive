package com.hw.kafka.quiz.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "users")
@Getter @ToString @RequiredArgsConstructor @EqualsAndHashCode
public class User implements Serializable {
    @Id
    private final String userid;
    private final String alias;
}
