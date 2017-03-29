package com.dalgim.sample.soap.mapper;

import com.dalgim.sample.soap.domain.Person;
import com.dalgim.sample.soap.entity.PersonEntity;
import com.google.common.base.Preconditions;
import org.springframework.stereotype.Component;

/**
 * Created by dalgim on 25.03.2017.
 */
@Component
public class PersonMapper implements ObjectMapper<Person, PersonEntity> {

    @Override
    public Person map(PersonEntity personEntity) {
        if (personEntity == null) {
            return null;
        }

        return Person.builder()
                .firstname(personEntity.getFirstname())
                .lastname(personEntity.getLastname())
                .login(personEntity.getLogin())
                .password(personEntity.getPassword())
                .build();
    }

    @Override
    public PersonEntity reverseMap(Person person) {
        if (person == null) {
            return null;
        }

        return PersonEntity.builder()
                .firstname(person.getFirstname())
                .lastname(person.getLastname())
                .login(person.getLogin())
                .password(person.getPassword())
                .build();
    }
}
