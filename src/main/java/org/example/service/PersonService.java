package org.example.service;


import lombok.RequiredArgsConstructor;
import org.example.exception.BusinessException;
import org.example.entity.Person;
import org.example.mapper.PersonMapper;
import org.example.model.person.PersonRequest;
import org.example.model.person.PersonResponse;
import org.example.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonResponse createPerson(PersonRequest personRequest) {
        Person person = personMapper.map(personRequest);
        return personMapper.map(personRepository.save(person));
    }

    public List<PersonResponse> getAllPersons() {

        return personMapper.map(personRepository.findAll());
    }

    public List<PersonResponse> findAll() {

        return personMapper.map(personRepository.findAll());
    }

    public PersonResponse save(PersonRequest personRequest) {
        return personMapper.map(personRepository.save(personMapper.map(personRequest)));
    }

    public PersonResponse findById(Integer id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new BusinessException("Cannot find person with ID" + id));
        return personMapper.map(person);
    }

    public void updatePersonName(Integer id, PersonRequest personRequest) {
        Person personToUpdate = personRepository.findById(personRequest.getId()).orElseThrow(
                () -> new BusinessException(String.format("Person with id: %s is not found", id))
        );
        personToUpdate.setName(personRequest.getName());

    }

    public void deleteById(Integer id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new BusinessException("Cannot find person with ID" + id));
        personRepository.delete(person);
    }
}
