package org.example.mapper;

import org.example.entity.Person;
import org.example.model.PersonRequest;
import org.example.model.PersonResponse;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;


import java.util.List;

@Mapper(componentModel = "spring")
@ComponentScan
public interface PersonMapper {

    Person map(PersonRequest personRequest);

    PersonResponse map(Person person);

    List<PersonResponse> map(List<Person> all);

}
