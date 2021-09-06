package com.hw.kafka.quiz.service;

import com.hw.kafka.quiz.domain.Attempt;
import com.hw.kafka.quiz.domain.Quiz;
import com.hw.kafka.quiz.domain.User;
import com.hw.kafka.quiz.repository.AttemptRepository;
import com.hw.kafka.quiz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService{
    private final UserRepository userRepository;
    private final GeneratorService generatorService;
    private final AttemptRepository attemptRepository;


    @Override
    public Mono<Quiz> createQuiz() {
        int factorA = generatorService.randomFactor();
        int factorB = generatorService.randomFactor();
        Quiz quiz = new Quiz(factorA, factorB);
        return Mono.just(quiz);
    }

    @Override
    public boolean checkAttempt(Attempt attempt) {
        Optional<User> user = userRepository.findByAlias(attempt.getUser().getAlias());

        Assert.isTrue(!attempt.isCorrect(), "Unable to send in graded stats");

        boolean isCorrect = attempt.getResultAttempt() == attempt.getQuiz().getFactorA() *
                attempt.getQuiz().getFactorB();

        Attempt checkAttempt = new Attempt(attempt.getUser(), attempt.getQuiz(), attempt.getResultAttempt(), isCorrect);

        attemptRepository.save(checkAttempt);

        return isCorrect;
    }

    @Override
    public Flux<Attempt> getStatsForUser(String alias) {
        return attemptRepository.findTop5ByUserAliasOrderByIdDesc(alias);
    }

    @Override
    public Mono<Attempt> getResultsById(Long id) {
        return null;
    }
}