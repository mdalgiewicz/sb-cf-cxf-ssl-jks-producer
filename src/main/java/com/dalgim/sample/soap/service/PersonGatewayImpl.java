package com.dalgim.sample.soap.service;

import com.dalgim.sample.soap.dto.PersonDTO;
import com.dalgim.sample.soap.mapper.PersonMapper;
import com.dalgim.sample.soap.model.Person;
import com.dalgim.sample.soap.repository.PersonRepository;
import com.google.common.base.Preconditions;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by dalgim on 25.03.2017.
 */
@Service
@Transactional
@AllArgsConstructor
public class PersonGatewayImpl implements PersonGateway {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public Optional<PersonDTO> findPersonByLogin(String login) {
        Preconditions.checkNotNull(login, "Login cannot be null.");

        PersonDTO personDTO = personMapper.map(personRepository.findByLogin(login));
        return Optional.ofNullable(personDTO);
    }

    @Override
    public void createPerson(PersonDTO personDTO) {
        Preconditions.checkNotNull(personDTO, "PersonDto cannot be null.");

        Person person = personMapper.reverseMap(personDTO);
        personRepository.save(person);
    }

    @Override
    public Collection<PersonDTO> getAllPersons() {
        Iterable<Person> allPersons = personRepository.findAll();
        return StreamSupport.stream(allPersons.spliterator(), false)
                .map(personMapper::map)
                .collect(Collectors.toList());
    }
}
