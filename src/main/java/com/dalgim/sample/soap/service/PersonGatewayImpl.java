package com.dalgim.sample.soap.service;

import com.dalgim.sample.soap.domain.Person;
import com.dalgim.sample.soap.entity.PersonEntity;
import com.dalgim.sample.soap.mapper.PersonMapper;
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
 * Created by Mateusz Dalgiewicz on 25.03.2017.
 */
@Service
@Transactional
@AllArgsConstructor
public class PersonGatewayImpl implements PersonGateway {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public Optional<Person> findPersonByLogin(String login) {
        Preconditions.checkNotNull(login, "Login cannot be null.");

        Person person = personMapper.map(personRepository.findByLogin(login));
        return Optional.ofNullable(person);
    }

    @Override
    public Person createPerson(Person person) {
        Preconditions.checkNotNull(person, "PersonDto cannot be null.");

        PersonEntity personEntity = personMapper.reverseMap(person);
        personRepository.save(personEntity);
        return personMapper.map(personEntity);
    }

    @Override
    public Collection<Person> getAllPersons() {
        Iterable<PersonEntity> allPersons = personRepository.findAll();
        return StreamSupport.stream(allPersons.spliterator(), false)
                .map(personMapper::map)
                .collect(Collectors.toList());
    }
}
