package com.dalgim.sample.soap.endpoint.mapper

import com.dalgim.namespace.personservice.general.GetPersonInfoResponse
import com.dalgim.sample.soap.domain.Person
import spock.lang.Specification

/**
 * Created by dalgim on 29.03.2017.
 */
class GetPersonInfoResponseMapperTest extends Specification {

    GetPersonInfoResponseMapper getPersonInfoResponseMapper

    void setup() {
        getPersonInfoResponseMapper = new GetPersonInfoResponseMapper()

    }

    def "should map Person into GetPersonInfoResponse"() {
        given:
            def person = Person.builder()
                    .firstname('John')
                    .lastname('Smith')
                    .login('John.Smith')
                    .password('xxx')
                    .build()
        when:
            GetPersonInfoResponse getPersonInfoResponse = getPersonInfoResponseMapper.map(person)
        then:
            getPersonInfoResponseMapper != null
            person.getFirstname() == getPersonInfoResponse.getFirstname()
            person.getLastname() == getPersonInfoResponse.getLastname()
            person.getLogin() == getPersonInfoResponse.getLogin()
            person.getPassword() == getPersonInfoResponse.getPassword()
    }

    def "should return null when PersonDTO is null"() {
        expect:
            getPersonInfoResponseMapper.map(null) == null

    }
}
