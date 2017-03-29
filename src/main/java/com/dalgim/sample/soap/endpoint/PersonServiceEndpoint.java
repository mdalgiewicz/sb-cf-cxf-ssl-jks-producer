package com.dalgim.sample.soap.endpoint;

import com.dalgim.namespace.personservice.PersonService;
import com.dalgim.namespace.personservice.general.GetPersonInfoRequest;
import com.dalgim.namespace.personservice.general.GetPersonInfoResponse;
import com.dalgim.sample.soap.endpoint.model.GetPersonInfoResponseMapper;
import com.dalgim.sample.soap.service.PersonGateway;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;

/**
 * Created by dalgim on 26.03.2017.
 */
@WebService(endpointInterface = "com.dalgim.namespace.personservice.PersonService", serviceName = "PersonService")
public class PersonServiceEndpoint implements PersonService {

    private PersonGateway personGateway;
    private GetPersonInfoResponseMapper getPersonInfoResponseMapper;

    @Override
    public GetPersonInfoResponse getPersonInformation(GetPersonInfoRequest personInfoRequest) {
        return personGateway.findPersonByLogin(personInfoRequest.getLogin())
                .map(getPersonInfoResponseMapper::map)
                .orElse(null);
    }

    @Autowired
    public void setPersonGateway(PersonGateway personGateway) {
        this.personGateway = personGateway;
    }

    @Autowired
    public void setGetPersonInfoResponseMapper(GetPersonInfoResponseMapper getPersonInfoResponseMapper) {
        this.getPersonInfoResponseMapper = getPersonInfoResponseMapper;
    }
}

