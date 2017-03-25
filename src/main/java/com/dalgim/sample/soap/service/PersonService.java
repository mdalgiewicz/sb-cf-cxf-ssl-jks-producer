package com.dalgim.sample.soap.service;

import com.dalgim.sample.soap.dto.PersonDTO;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by dalgim on 25.03.2017.
 */
public interface PersonService {

    Optional<PersonDTO> findPersonByLogin(String login);
    void createPerson(PersonDTO personDTO);
    Collection<PersonDTO> getAllPersons();
}
