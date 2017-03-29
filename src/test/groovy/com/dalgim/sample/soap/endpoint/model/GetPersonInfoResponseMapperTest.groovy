package com.dalgim.sample.soap.endpoint.model

import com.dalgim.namespace.personservice.general.GetPersonInfoResponse
import com.dalgim.sample.soap.dto.PersonDTO
import spock.lang.Specification

/**
 * Created by dalgim on 29.03.2017.
 */
class GetPersonInfoResponseMapperTest extends Specification {

    GetPersonInfoResponseMapper getPersonInfoResponseMapper

    void setup() {
        getPersonInfoResponseMapper = new GetPersonInfoResponseMapper()

    }

    def "should map PersonDTO into GetPersonInfoResponse."() {
        given:
            def personDTO = PersonDTO.builder()
                    .firstname('John')
                    .lastname('Smith')
                    .login('John.Smith')
                    .password('xxx')
                    .build()
        when:
            GetPersonInfoResponse getPersonInfoResponse = getPersonInfoResponseMapper.map(personDTO)
        then:
            getPersonInfoResponseMapper != null
            personDTO.getFirstname() == getPersonInfoResponse.getFirstname()
            personDTO.getLastname() == getPersonInfoResponse.getLastname()
            personDTO.getLogin() == getPersonInfoResponse.getLogin()
            personDTO.getPassword() == getPersonInfoResponse.getPassword()
    }

    def "should return null when PersonDTO is null"() {
        expect:
            getPersonInfoResponseMapper.map(null) == null

    }
}
