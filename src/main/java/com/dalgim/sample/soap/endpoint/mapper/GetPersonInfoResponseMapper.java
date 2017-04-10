package com.dalgim.sample.soap.endpoint.mapper;

import com.dalgim.namespace.personservice.datatypes.PersonInfo;
import com.dalgim.namespace.personservice.general.GetPersonInfoResponse;
import com.dalgim.sample.soap.domain.Person;
import org.springframework.stereotype.Component;

/**
 * Created by Mateusz Dalgiewicz on 29.03.2017.
 */
@Component
public class GetPersonInfoResponseMapper implements NoReverseMapper<GetPersonInfoResponse, Person> {

    @Override
    public GetPersonInfoResponse map(Person domainModel) {
        if (domainModel == null) {
            return null;
        }

        GetPersonInfoResponse getPersonInfoResponse = new GetPersonInfoResponse();
        PersonInfo personInfo = new PersonInfo();
        personInfo.setLogin(domainModel.getLogin());
        personInfo.setFirstname(domainModel.getFirstname());
        personInfo.setLastname(domainModel.getLastname());
        personInfo.setPassword(domainModel.getPassword());
        personInfo.setId(domainModel.getId());
        getPersonInfoResponse.setPersonInfo(personInfo);
        return getPersonInfoResponse;
    }
}
