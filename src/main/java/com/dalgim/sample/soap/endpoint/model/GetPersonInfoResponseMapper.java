package com.dalgim.sample.soap.endpoint.model;

import com.dalgim.namespace.personservice.general.GetPersonInfoResponse;
import com.dalgim.sample.soap.dto.PersonDTO;
import org.springframework.stereotype.Component;

/**
 * Created by dalgim on 29.03.2017.
 */
@Component
public class GetPersonInfoResponseMapper implements EndpointObjectOutMapper<GetPersonInfoResponse, PersonDTO> {

    @Override
    public GetPersonInfoResponse map(PersonDTO domainModel) {
        if (domainModel == null) {
            return null;
        }
        GetPersonInfoResponse getPersonInfoResponse = new GetPersonInfoResponse();
        getPersonInfoResponse.setLogin(domainModel.getLogin());
        getPersonInfoResponse.setFirstname(domainModel.getFirstname());
        getPersonInfoResponse.setLastname(domainModel.getLastname());
        getPersonInfoResponse.setPassword(domainModel.getPassword());
        return getPersonInfoResponse;
    }
}
