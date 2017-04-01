package com.dalgim.sample.soap.mapper

import com.dalgim.sample.soap.domain.Person
import com.dalgim.sample.soap.entity.PersonEntity
import spock.lang.Specification

/**
 * Created by dalgim on 25.03.2017.
 */
class PersonMapperTest extends Specification {

    PersonMapper personMapper

    void setup() {
        personMapper = new PersonMapper()
    }

    def "should map PersonEntity into Person"() {
        given:
            def personEntity = new PersonEntity()
            personEntity.setFirstname('John')
            personEntity.setLastname('Smith')
            personEntity.setLogin('John.Smith')
            personEntity.setPassword('secret')
            personEntity.setId(10L)
        when:
            def person = personMapper.map(personEntity)
        then:
            person != null
            person.getFirstname() == personEntity.getFirstname()
            person.getLastname() == personEntity.getLastname()
            person.getLogin() == personEntity.getLogin()
            person.getPassword() == personEntity.getPassword()
            person.getId() == personEntity.getId()
    }

    def "should return null while PersonEntity is null"() {
        expect:
            personMapper.map(null) == null
    }

    def "should map Person into PersonEntity."() {
        given:
            def person = Person.builder()
                    .firstname('John')
                    .lastname('Smith')
                    .login('John.Smith')
                    .password('seret')
                    .build()
        when:
            def personEntiy = personMapper.reverseMap(person)
        then:
            personEntiy != null
            personEntiy.getFirstname() == person.getFirstname()
            personEntiy.getLastname() == person.getLastname()
            personEntiy.getLogin() == person.getLogin()
            personEntiy.getPassword() == person.getPassword()
            personEntiy.getUuid() != null
            personEntiy.getId() == null
    }

    def "should return null while Person is null"() {
        expect:
            personMapper.reverseMap(null) == null
    }
}
