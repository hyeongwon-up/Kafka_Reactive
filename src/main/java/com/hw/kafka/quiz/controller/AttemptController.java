package com.hw.kafka.quiz.controller;

import com.hw.kafka.quiz.domain.Attempt;
import com.hw.kafka.quiz.service.QuizService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("/results")
public class AttemptController {
    private final QuizService quizService;

    @RequiredArgsConstructor
    @NoArgsConstructor(force = true)
    @Getter
    static final class ResultResponse{
        private final  boolean correct;
    }

    @PostMapping
    ResponseEntity<Attempt> postResult(@RequestBody Attempt attempt) {
        boolean isCorrect = quizService.checkAttempt(attempt);
        Attempt attemptCopy = new Attempt(attempt.getUser(), attempt.getQuiz(), attempt.getResultAttempt(), isCorrect);
        return ResponseEntity.ok(attemptCopy);
    }

    @GetMapping
    ResponseEntity<Flux<Attempt>> getStatistics(@RequestParam("alias") String alias) {
        return ResponseEntity.ok(quizService.getStatsForUser(alias));
    }

    @GetMapping("/{id}")
    ResponseEntity<Mono<Attempt>> getResultById(final @PathVariable Long id) {
        return ResponseEntity.ok(quizService.getResultsById(id));
    }


}
