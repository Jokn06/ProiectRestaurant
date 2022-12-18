package org.example.service;


import lombok.RequiredArgsConstructor;
import org.example.exception.BusinessException;
import org.example.repository.entity.Person;
import org.example.model.PersonRequest;
import org.example.model.PersonResponse;
import org.example.repository.PersonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonRepository personMapper;

    public List<PersonResponse> findAll() {
        return personMapper.map(personRepository.findAll());
    }

    public PersonResponse save(PersonRequest personRequest) {
        return personMapper.map(personRepository.save(personMapper.map(personRequest)));
    }

    public Person findById(Integer id) {
        return personRepository.findById(id).orElseThrow(() -> new BusinessException("Cannot find person with ID" + id));
    }

    public void deleteById(Integer id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new BusinessException("Cannot find person with ID" + id));
        personRepository.delete(person);
    }
}
