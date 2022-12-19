package org.example.repository;

import org.example.entity.Person;
import org.example.model.PersonResponse;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Integer> {


}
