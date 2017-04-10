package com.dalgim.sample.soap.endpoint.mapper;

import com.dalgim.namespace.personservice.general.CreatePersonRequest;
import com.dalgim.sample.soap.domain.Person;
import org.springframework.stereotype.Component;

/**
 * Created by Mateusz Dalgiewicz on 29.03.2017.
 */
@Component
public class CreatePersonRequestMapper implements NoReverseMapper<Person, CreatePersonRequest> {

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
