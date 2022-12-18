package org.example.data;


import lombok.RequiredArgsConstructor;
import org.example.repository.entity.Person;
import org.example.repository.PersonRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class PersonData {

    private final PersonRepository personRepository;


        @PostConstruct
        public void init(){
            Person person = new Person();
            person.setId(1);
            person.setName("Razvan");
            personRepository.save(person);
        }
    }

