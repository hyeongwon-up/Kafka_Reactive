package com.example.reactivmongopractice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "persons")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    private String id; // string 의 주소값이용?

    private String name;
    private String email;
}
