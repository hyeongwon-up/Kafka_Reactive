package com.hw.redis.controller;

import com.hw.redis.domain.User;
import com.hw.redis.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable String id){
        return userService.findById(id);
    }

    @PostMapping
    public ResponseEntity<User> createPerson(@RequestBody User user){
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
