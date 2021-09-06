package com.hw.kafka.quiz.controller;


import com.hw.kafka.quiz.domain.User;
import com.hw.kafka.quiz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public Flux<User> getAllPersons() {
        return userRepository.findAll();
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> streamAllPerson() {
        return userRepository.findAll();
    }

    @PostMapping
    public Mono<ResponseEntity<User>> createPerson(@RequestBody User person) {
        return userRepository.save(person).map(
                it -> {
                    return ResponseEntity.ok(it);
                }
        ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{id}")
    public Mono<ResponseEntity<User>> updatePerson(@PathVariable(value = "id") String id, @RequestBody User person) {
        return userRepository.findById(id)
                .flatMap(
                        it -> {
                            it.setName(person.getName());
                            it.setEmail(person.getEmail());
                            return userRepository.save(it);
                        }
                ).map(
                        res -> {
                            return ResponseEntity.ok(res);
                        }
                ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deletePerson(@PathVariable(value = "id") String id) {
        return userRepository.findById(id)
                .flatMap(
                        it -> userRepository.delete(it)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
