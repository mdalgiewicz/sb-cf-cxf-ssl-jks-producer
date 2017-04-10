package com.dalgim.sample.soap.endpoint.mapper

import com.dalgim.sample.soap.domain.Person
import spock.lang.Specification

/**
 * Created by Mateusz Dalgiewicz on 29.03.2017.
 */
class CreatePersonResponseMapperTest extends Specification {

    CreatePersonResponseMapper createPersonResponseMapper

    void setup() {
        createPersonResponseMapper = new CreatePersonResponseMapper()
    }

    def "should map CreatePersonRequest into Person"() {
        given:
            def person = Person.builder()
                    .firstname('John')
                    .lastname('Smith')
                    .login('John.Smith')
                    .password('xxx')
                    .build()
            person.setId(10l)
        when:
            def createPersonResponse = createPersonResponseMapper.map(person)
        then:
            createPersonResponse != null
            createPersonResponse.getPersonInfo().getFirstname() == person.getFirstname()
            createPersonResponse.getPersonInfo().getLogin() == person.getLogin()
            createPersonResponse.getPersonInfo().getLastname() == person.getLastname()
            createPersonResponse.getPersonInfo().getPassword() == person.getPassword()
            createPersonResponse.getPersonInfo().getId() == person.getId()
    }

    def "should return null while CreatePersonRequest is null"() {
        expect:
            createPersonResponseMapper.map(null) == null
    }
}
