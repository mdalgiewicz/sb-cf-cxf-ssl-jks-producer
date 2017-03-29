package com.dalgim.sample.soap.endpoint.model;

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
        if (endpointModel == null) {
            return null;
        }
        return Person.builder()
                .firstname(endpointModel.getFirstname())
                .lastname(endpointModel.getLastname())
                .login(endpointModel.getLogin())
                .password(endpointModel.getPassword())
                .build();
    }
}
