package com.dalgim.sample.soap.endpoint.mapper

import com.dalgim.namespace.personservice.general.GetAllPersonInfoResponse
import com.dalgim.sample.soap.domain.Person
import org.assertj.core.util.Lists
import spock.lang.Specification

/**
 * Created by dalgim on 01.04.2017.
 */
class GetAllPersonInfoResponseMapperTest extends Specification {

    GetPersonInfoResponseMapper getPersonInfoResponseMapper
    GetAllPersonInfoResponseMapper getAllPersonInfoResponseMapper

    void setup() {
        getPersonInfoResponseMapper = new GetPersonInfoResponseMapper()
        getAllPersonInfoResponseMapper = new GetAllPersonInfoResponseMapper(getPersonInfoResponseMapper)
    }

    def "should map Person list into PersonInfo list"() {
        given:
            def person1 = Person.builder()
                    .firstname('John')
                    .lastname('Smith')
                    .login('John.Smith')
                    .password('xxx')
                    .build()
            person1.setId(10l)
            def person2 = Person.builder()
                    .firstname('John')
                    .lastname('Smith')
                    .login('John.Smith')
                    .password('xxx')
                    .build()
            person2.setId(11l)
            def personList = [person1, person2]
        when:
            GetAllPersonInfoResponse getAllPersonInfoResponse = getAllPersonInfoResponseMapper.map(personList)
        then:
            getAllPersonInfoResponse != null
            getAllPersonInfoResponse.getPersonInfoList() != null
            getAllPersonInfoResponse.getPersonInfoList().size() == 2
    }

    def "should return null while Person list is null"() {
        expect:
            getAllPersonInfoResponseMapper.map(null) == null
    }

    def "should return null while Person list is empty"() {
        expect:
            getAllPersonInfoResponseMapper.map(Lists.emptyList()) == null
    }
}

