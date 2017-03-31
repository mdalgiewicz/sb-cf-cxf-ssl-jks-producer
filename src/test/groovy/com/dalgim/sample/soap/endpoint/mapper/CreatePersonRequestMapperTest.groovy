package com.dalgim.sample.soap.endpoint.mapper

import com.dalgim.namespace.personservice.general.CreatePersonRequest
import spock.lang.Specification

/**
 * Created by dalgim on 29.03.2017.
 */
class CreatePersonRequestMapperTest extends Specification {

    CreatePersonRequestMapper createPersonRequestMapper

    void setup() {
        createPersonRequestMapper = new CreatePersonRequestMapper()
    }

    def "should map CreatePersonRequest into Person"() {
        given:
            CreatePersonRequest createPersonRequest = new CreatePersonRequest();
            createPersonRequest.setFirstname('John')
            createPersonRequest.setLastname('Smith')
            createPersonRequest.setLogin('John.Smith')
            createPersonRequest.setPassword('xxx')
        when:
            def person = createPersonRequestMapper.map(createPersonRequest)
        then:
            person != null
            person.getFirstname() == createPersonRequest.getFirstname()
            person.getLogin() == createPersonRequest.getLogin()
            person.getLastname() == createPersonRequest.getLastname()
            person.getPassword() == createPersonRequest.getPassword()
    }

    def "should return null while CreatePersonRequest is null"() {
        expect:
            createPersonRequestMapper.map(null) == null
    }
}
