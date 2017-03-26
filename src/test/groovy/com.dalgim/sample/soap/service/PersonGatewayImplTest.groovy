package com.dalgim.sample.soap.service

import com.dalgim.sample.soap.dto.PersonDTO
import com.dalgim.sample.soap.mapper.PersonMapper
import com.dalgim.sample.soap.model.Person
import com.dalgim.sample.soap.repository.PersonRepository
import spock.lang.Specification

/**
 * Created by dalgim on 25.03.2017.
 */
class PersonGatewayImplTest extends Specification {

    PersonGateway personService
    PersonRepository personRepository

    void setup() {
        personRepository = Mock(PersonRepository)
        personService = new PersonGatewayImpl(personRepository, new PersonMapper())
    }

    def "should create new Person"() {
        given:
            PersonDTO personDto = PersonDTO.builder()
                    .firstname('John')
                    .lastname('Smith')
                    .login('John.Smith')
                    .password('seret')
                    .build()
        when:
            personService.createPerson(personDto)
        then:
            1 * personRepository.save(_ as Person)
    }

    def "should finds all persons"() {
       /* given:
            Person person1 = Person.builder()
                    .firstname('John1')
                    .lastname('Smith1')
                    .login('John1.Smith1')
                    .password('seret')
                    .build()
            Person person2 = Person.builder()
                    .firstname('John2')
                    .lastname('Smith2')
                    .login('John2.Smith2')
                    .password('seret')
                    .build()
            List<Person> personLists = Lists.newArrayList(person1, person2)
            PersonMapper personMapper = new PersonMapper()
        and:
            personRepository.findAll() >> personLists
        when:
            List<PersonDTO> personDTOList = personGateway.getAllPersons()
        then:
            1 * personRepository.findAll()
            personDTOList != null
            personDTOList.size() == 2
            personDTOList.contains(personMapper.map(person1))*/
    }

    def "should find person by login"() {
        given:
            String login = "John1.Smith1"
        Person person = Person.builder()
                .firstname('John1')
                .lastname('Smith1')
                .login('John1.Smith1')
                .password('seret')
                .build()
        and:
            personRepository.findByLogin(login) >> person
        when:
            Optional<PersonDTO> personDTO = personService.findPersonByLogin(login)
        then:
            personDTO.isPresent()
            personDTO.get().getLogin() == person.getLogin()
            personDTO.get().getFirstname() == person.getFirstname()
            personDTO.get().getLastname() == person.getLastname()
            personDTO.get().getPassword() == person.getPassword()
    }
}
