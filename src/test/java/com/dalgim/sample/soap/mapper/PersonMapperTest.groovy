package com.dalgim.sample.soap.mapper

import com.dalgim.sample.soap.dto.PersonDTO
import com.dalgim.sample.soap.model.Person
import spock.lang.Specification

/**
 * Created by dalgim on 25.03.2017.
 */
class PersonMapperTest extends Specification {

    PersonMapper personMapper;

    void setup() {
        personMapper = new PersonMapper();
    }

    def "should map Person into PersonDTO"() {
        given:
            Person person = Person.builder()
                    .firstname('John')
                    .lastname('Smith')
                    .login('John.Smith')
                    .password('seret')
                    .build()
        when:
            PersonDTO personDTO = personMapper.map(person)
        then:
            personDTO != null
            personDTO.getFirstname() == person.getFirstname()
            personDTO.getLastname() == person.getLastname()
            personDTO.getLogin() == person.getLogin()
            personDTO.getPassword() == person.getPassword()
    }

    def "should map PersonDTO into Person"() {
        given:
            PersonDTO personDto = PersonDTO.builder()
                    .firstname('John')
                    .lastname('Smith')
                    .login('John.Smith')
                    .password('seret')
                    .build()
        when:
        Person person = personMapper.reverseMap(personDto)
        then:
        person != null
        person.getFirstname() == personDto.getFirstname()
        person.getLastname() == personDto.getLastname()
        person.getLogin() == personDto.getLogin()
        person.getPassword() == personDto.getPassword()
        person.getUuid() != null
        person.getId() == null


    }
}
