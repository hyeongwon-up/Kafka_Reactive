package com.hw.kafka.quiz.service;

import com.hw.kafka.quiz.domain.Attempt;
import com.hw.kafka.quiz.domain.Quiz;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public interface QuizService {
    Mono<Quiz> createQuiz();

    boolean checkAttempt(Attempt attempt);

    Flux<Attempt> getStatsForUser(String alias);

    Mono<Attempt> getResultsById(Long id);
}