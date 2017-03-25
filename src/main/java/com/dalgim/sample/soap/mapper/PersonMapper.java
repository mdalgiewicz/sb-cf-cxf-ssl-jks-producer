package com.dalgim.sample.soap.mapper;

import com.dalgim.sample.soap.dto.PersonDTO;
import com.dalgim.sample.soap.model.Person;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;

/**
 * Created by dalgim on 25.03.2017.
 */
@Component
public class PersonMapper implements ObjectMapper<PersonDTO, Person> {

    @Override
    public PersonDTO map(Person person) {
        Preconditions.checkNotNull(person, "Person cannot be null.");

        return PersonDTO.builder()
                .firstname(person.getFirstname())
                .lastname(person.getLastname())
                .login(person.getLogin())
                .password(person.getPassword())
                .build();
    }

    @Override
    public Person reverseMap(PersonDTO personDTO) {
        Preconditions.checkNotNull(personDTO, "PersonDTO cannot be null.");

        return Person.builder()
                .firstname(personDTO.getFirstname())
                .lastname(personDTO.getLastname())
                .login(personDTO.getLogin())
                .password(personDTO.getPassword())
                .build();
    }
}
