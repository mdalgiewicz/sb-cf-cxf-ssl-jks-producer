package com.dalgim.sample.soap.endpoint.mapper;

import com.dalgim.namespace.personservice.datatypes.PersonInfo;
import com.dalgim.namespace.personservice.general.CreatePersonResponse;
import com.dalgim.sample.soap.domain.Person;
import org.springframework.stereotype.Component;

/**
 * Created by Mateusz Dalgiewicz on 29.03.2017.
 */
@Component
public class CreatePersonResponseMapper implements NoReverseMapper<CreatePersonResponse, Person> {

    @Override
    public CreatePersonResponse map(Person domainModel) {
        if (domainModel == null) {
            return null;
        }

        CreatePersonResponse createPersonResponse = new CreatePersonResponse();
        PersonInfo personInfo = new PersonInfo();
        personInfo.setFirstname(domainModel.getFirstname());
        personInfo.setLastname(domainModel.getLastname());
        personInfo.setLogin(domainModel.getLogin());
        personInfo.setPassword(domainModel.getPassword());
        personInfo.setId(domainModel.getId());
        createPersonResponse.setPersonInfo(personInfo);
        return createPersonResponse;
    }
}
