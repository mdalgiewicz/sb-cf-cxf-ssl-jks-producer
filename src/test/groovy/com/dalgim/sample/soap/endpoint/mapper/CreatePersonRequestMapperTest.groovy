package com.dalgim.sample.soap.endpoint.mapper

import com.dalgim.namespace.personservice.datatypes.PersonInfo
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
            PersonInfo personInfo = new PersonInfo();
            personInfo.setFirstname('John')
            personInfo.setLastname('Smith')
            personInfo.setLogin('John.Smith')
            personInfo.setPassword('xxx')
            createPersonRequest.setPersonInfo(personInfo)
        when:
            def person = createPersonRequestMapper.map(createPersonRequest)
        then:
            person != null
            person.getFirstname() == createPersonRequest.getPersonInfo().getFirstname()
            person.getLogin() == createPersonRequest.getPersonInfo().getLogin()
            person.getLastname() == createPersonRequest.getPersonInfo().getLastname()
            person.getPassword() == createPersonRequest.getPersonInfo().getPassword()
    }

    def "should return null while CreatePersonRequest is null"() {
        expect:
            createPersonRequestMapper.map(null) == null
    }
}
