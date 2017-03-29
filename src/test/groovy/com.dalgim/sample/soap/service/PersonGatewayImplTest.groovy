package com.dalgim.sample.soap.service

import com.dalgim.sample.soap.domain.Person
import com.dalgim.sample.soap.mapper.PersonMapper
import com.dalgim.sample.soap.entity.PersonEntity
import com.dalgim.sample.soap.repository.PersonRepository
import spock.lang.Specification

/**
 * Created by dalgim on 25.03.2017.
 */
class PersonGatewayImplTest extends Specification {

    PersonGateway personGateway
    PersonRepository personRepository

    void setup() {
        personRepository = Mock(PersonRepository)
        personGateway = new PersonGatewayImpl(personRepository, new PersonMapper())
    }

    def "should create new Person"() {
        given:
            Person person = Person.builder()
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

    def "should finds all persons"() {
      /*  given:
            PersonEntity person1 = PersonEntity.builder()
                    .firstname('John1')
                    .lastname('Smith1')
                    .login('John1.Smith1')
                    .password('seret')
                    .build()
            PersonEntity person2 = PersonEntity.builder()
                    .firstname('John2')
                    .lastname('Smith2')
                    .login('John2.Smith2')
                    .password('seret')
                    .build()
            List<PersonEntity> personLists = Lists.newArrayList(person1, person2)
            PersonMapper personMapper = new PersonMapper()
        and:
            personRepository.findAll() >> {x -> [person1, person2]}
        when:
            List<Person> personDTOList = personGateway.getAllPersons()
        then:
            1 * personRepository.findAll()
            personDTOList != null
            personDTOList.size() == 2
            personDTOList.contains(personMapper.map(person1))*/
    }

    def "should find person by login"() {
        given:
            String login = "John1.Smith1"
        PersonEntity personEntity = PersonEntity.builder()
                .firstname('John1')
                .lastname('Smith1')
                .login('John1.Smith1')
                .password('seret')
                .build()
        and:
            personRepository.findByLogin(login) >> personEntity
        when:
            Optional<Person> person = personGateway.findPersonByLogin(login)
        then:
            person.isPresent()
            person.get().getLogin() == personEntity.getLogin()
            person.get().getFirstname() == personEntity.getFirstname()
            person.get().getLastname() == personEntity.getLastname()
            person.get().getPassword() == personEntity.getPassword()
    }

}
