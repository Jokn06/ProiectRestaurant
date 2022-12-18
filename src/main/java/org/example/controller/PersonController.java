package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.PersonRequest;
import org.example.model.PersonResponse;
import org.example.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public List<PersonResponse> findAll() {
        return personService.findAll();
    }

    @GetMapping("{id}")
    public PersonResponse findById(@PathVariable("id") Integer id) {
        return personService.findById(id);
    }

    @PostMapping
    public PersonResponse save(@RequestBody PersonRequest personRequest) {
        return personService.save(personRequest);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        personService.deleteById(id);
    }
}
