package com.hw.kafka.quiz.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GeneratorServiceImplTest {

    @Mock GeneratorService generatorService;
    @BeforeEach
    void setUp() {
        generatorService = new GeneratorServiceImpl();
    }


}