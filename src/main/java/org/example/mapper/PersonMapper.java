package org.example.mapper;

import org.example.repository.entity.Person;
import org.example.model.PersonRequest;
import org.example.model.PersonResponse;
import org.mapstruct.Mapper;


import java.util.List;
@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonResponse map(Person person);

    Person map (PersonRequest personRequest);

  List<PersonResponse> map(List<Person> all);

}
