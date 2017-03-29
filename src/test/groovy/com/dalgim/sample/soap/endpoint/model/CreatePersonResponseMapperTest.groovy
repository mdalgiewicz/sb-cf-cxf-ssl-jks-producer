package com.dalgim.sample.soap.endpoint.model

import com.dalgim.sample.soap.domain.Person
import spock.lang.Specification

/**
 * Created by dalgim on 29.03.2017.
 */
class CreatePersonResponseMapperTest extends Specification {

    CreatePersonResponseMapper createPersonResponseMapper

    void setup() {
        createPersonResponseMapper = new CreatePersonResponseMapper()
    }

    def "should map CreatePersonRequest into Person"() {
        given:
            Person person = Person.builder()
                    .firstname('John')
                    .lastname('Smith')
                    .login('John.Smith')
                    .password('xxx')
                    .build()
        when:
            def createPersonResponse = createPersonResponseMapper.map(person)
        then:
            createPersonResponse != null
            createPersonResponse.getFirstname() == person.getFirstname()
            createPersonResponse.getLogin() == person.getLogin()
            createPersonResponse.getLastname() == person.getLastname()
            createPersonResponse.getPassword() == person.getPassword()
    }

    def "should return null while CreatePersonRequest is null"() {
        expect:
            createPersonResponseMapper.map(null) == null
    }
}
