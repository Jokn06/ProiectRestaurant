package org.example.repository;

import org.example.model.PersonResponse;
import org.example.repository.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PersonRepository extends JpaRepository<Person, Integer> {



}
