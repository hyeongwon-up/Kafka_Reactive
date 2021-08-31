package com.hw.kafka.quiz.domain;

public enum Factor {
    MINIMUM, MAXIMUM;

    @Override
    public String toString() {
        String value = "";
        switch (this){
            case MINIMUM:value = String.valueOf(11); break;
            case MAXIMUM:value = String.valueOf(99); break;
        }
        return value;
    }
}