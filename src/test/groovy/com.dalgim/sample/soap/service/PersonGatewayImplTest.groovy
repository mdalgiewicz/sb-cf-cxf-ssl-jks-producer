package com.dalgim.sample.soap.service

import com.dalgim.sample.soap.domain.Person
import com.dalgim.sample.soap.mapper.PersonMapper
import com.dalgim.sample.soap.entity.PersonEntity
import com.dalgim.sample.soap.repository.PersonRepository
import spock.lang.Specification

/**
 * Created by Mateusz Dalgiewicz on 25.03.2017.
 */
class PersonGatewayImplTest extends Specification {

    PersonGateway personGateway
    PersonRepository personRepository
    PersonMapper personMapper

    void setup() {
        personMapper = new PersonMapper()
        personRepository = Mock(PersonRepository)
        personGateway = new PersonGatewayImpl(personRepository, personMapper)
    }

    def "should create new Person"() {
        given:
            def person = Person.builder()
                    .firstname('John')
                    .lastname('Smith')
                    .login('John.Smith')
                    .password('seret')
                    .build()
        when:
            def personAfterCreate = personGateway.createPerson(person)
        then:
            1 * personRepository.save(_ as PersonEntity)
            personAfterCreate != null
            personAfterCreate.getFirstname() == person.getFirstname()
            personAfterCreate.getLastname() == person.getLastname()
            personAfterCreate.getLogin() == person.getLogin()
            personAfterCreate.getPassword() == person.getPassword()
    }

    def "should returns all Persons"() {
        given:
            def person1 = new PersonEntity()
            person1.setFirstname('John1')
            person1.setLogin('Smith1')
            person1.setLogin('John1.Smith1')
            person1.setPassword('seret')
            person1.setId(1L)
            def person2 = new PersonEntity()
            person2.setFirstname('John2')
            person2.setLastname('Smith2')
            person2.setLogin('John2.Smith2')
            person2.setPassword('seret')
            person2.setId(2L)
        and:
            personRepository.findAll() >> [person1, person2]
        when:
            def personDTOList = personGateway.getAllPersons()
        then:
            personDTOList != null
            personDTOList.size() == 2
            personDTOList.contains(personMapper.map(person1))
            personDTOList.contains(personMapper.map(person2))
    }

    def "should find Person by login"() {
        given:
            def login = "John1.Smith1"
            def personEntity = new PersonEntity()
            personEntity.setFirstname('John1')
            personEntity.setLastname('Smith1')
            personEntity.setLogin('John1.Smith1')
            personEntity.setPassword('seret')
            personEntity.setId(1L)
        and:
            personRepository.findByLogin(login) >> personEntity
        when:
            def person = personGateway.findPersonByLogin(login)
        then:
            person.isPresent()
            person.get().getLogin() == personEntity.getLogin()
            person.get().getFirstname() == personEntity.getFirstname()
            person.get().getLastname() == personEntity.getLastname()
            person.get().getPassword() == personEntity.getPassword()
            person.get().getId() == personEntity.getId()
    }

}
