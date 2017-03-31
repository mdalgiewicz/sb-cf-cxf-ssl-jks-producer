package com.dalgim.sample.soap.endpoint.mapper;

import com.dalgim.namespace.personservice.general.CreatePersonResponse;
import com.dalgim.sample.soap.domain.Person;
import org.springframework.stereotype.Component;

/**
 * Created by dalgim on 29.03.2017.
 */
@Component
public class CreatePersonResponseMapper implements EndpointObjectOutMapper<CreatePersonResponse, Person> {

    @Override
    public CreatePersonResponse map(Person domainModel) {
        if (domainModel == null) {
            return null;
        }

        CreatePersonResponse createPersonResponse = new CreatePersonResponse();
        createPersonResponse.setFirstname(domainModel.getFirstname());
        createPersonResponse.setLastname(domainModel.getLastname());
        createPersonResponse.setLogin(domainModel.getLogin());
        createPersonResponse.setPassword(domainModel.getPassword());
        return createPersonResponse;
    }
}
