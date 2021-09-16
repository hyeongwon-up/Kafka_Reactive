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

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> streamAllPerson() {
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

    @PostMapping("/{id}")
    public Mono<ResponseEntity<Person>> updatePerson(@PathVariable(value = "id") String id, @RequestBody Person person) {
        return personRepository.findById(id)
                .flatMap(
                        it -> {
                            it.setName(person.getName());
                            it.setEmail(person.getEmail());
                            return personRepository.save(it);
                        }
                ).map(
                        res -> {
                            return ResponseEntity.ok(res);
                        }
                ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deletePerson(@PathVariable(value = "id") String id) {
        return personRepository.findById(id)
                .flatMap(
                        it -> personRepository.delete(it)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                ).defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}
