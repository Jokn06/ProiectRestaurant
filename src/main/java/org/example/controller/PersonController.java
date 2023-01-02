package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.person.PersonRequest;
import org.example.model.person.PersonResponse;
import org.example.service.PersonService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("person")
@RequiredArgsConstructor
@Validated
public class PersonController {

    private final PersonService personService;

    @PostMapping("create")
    public PersonResponse createPerson(@RequestBody @Valid PersonRequest personRequest) {
        return personService.createPerson(personRequest);
    }

    @GetMapping("list")
    public List<PersonResponse> getAllPersons() {

        return personService.getAllPersons();
    }

//    @GetMapping
//    public List<PersonResponse> findAll() {
//        return personService.findAll();
//    }

    @GetMapping("{id}")
    public PersonResponse findById(@PathVariable("id") Integer id) {

        return personService.findById(id);
    }

//    @PostMapping
//    public PersonResponse save(@RequestBody PersonRequest personRequest) {
//        return personService.save(personRequest);
//    }

    @PatchMapping("update/{id}")
    public void updatePersonById(@PathVariable Integer id, @RequestBody @Valid PersonRequest personRequest) {
        personService.updatePersonName(id, personRequest);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id) {

        personService.deleteById(id);
    }
}
