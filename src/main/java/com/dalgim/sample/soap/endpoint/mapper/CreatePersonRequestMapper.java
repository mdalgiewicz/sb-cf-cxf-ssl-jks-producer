package com.dalgim.sample.soap.endpoint.mapper;

import com.dalgim.namespace.personservice.general.CreatePersonRequest;
import com.dalgim.sample.soap.domain.Person;
import org.springframework.stereotype.Component;

/**
 * Created by dalgim on 29.03.2017.
 */
@Component
public class CreatePersonRequestMapper implements EndpointObjectInMapper<CreatePersonRequest, Person> {

    @Override
    public Person map(CreatePersonRequest endpointModel) {
        if (endpointModel == null || endpointModel.getPersonInfo() == null) {
            return null;
        }
        return Person.builder()
                .firstname(endpointModel.getPersonInfo().getFirstname())
                .lastname(endpointModel.getPersonInfo().getLastname())
                .login(endpointModel.getPersonInfo().getLogin())
                .password(endpointModel.getPersonInfo().getPassword())
                .build();
    }
}
