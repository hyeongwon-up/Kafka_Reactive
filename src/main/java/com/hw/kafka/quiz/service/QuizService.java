package com.hw.kafka.quiz.service;

import com.hw.kafka.quiz.domain.Quiz;
import reactor.core.publisher.Mono;

public interface QuizService {
    Mono<Quiz> createQuiz();
}