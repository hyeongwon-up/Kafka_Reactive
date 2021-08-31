package com.hw.kafka.quiz.service;

import com.hw.kafka.quiz.domain.Attempt;
import com.hw.kafka.quiz.domain.Quiz;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QuizService {
    Mono<Quiz> createQuiz();

    boolean checkAttempt(Attempt attempt);

    Flux<Attempt> getStatsForUser(String alias);

    Mono<Attempt> getResultsById(Long id);
}