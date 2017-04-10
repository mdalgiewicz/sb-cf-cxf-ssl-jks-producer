package com.dalgim.sample.soap.service;

import com.dalgim.sample.soap.domain.Person;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by Mateusz Dalgiewicz on 25.03.2017.
 */
public interface PersonGateway {

    Optional<Person> findPersonByLogin(String login);
    Person createPerson(Person person);
    Collection<Person> getAllPersons();
}
