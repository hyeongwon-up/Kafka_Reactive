package com.example.reactivmongopractice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {
    private final PersonRepository personRepository;

    @GetMapping
    public Flux<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping(value = "/stream" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> streamAllPerson(){
        return personRepository.findAll();
    }

    @PostMapping
    public Mono<ResponseEntity<Person>> createPerson(@RequestBody Person person) {
        return personRepository.save(person).map(
                it -> {
                    return ResponseEntity.ok(it);
                }
        ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }





}
