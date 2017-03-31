package com.dalgim.sample.soap.endpoint;

import com.dalgim.namespace.personservice.PersonService;
import com.dalgim.namespace.personservice.general.CreatePersonRequest;
import com.dalgim.namespace.personservice.general.CreatePersonResponse;
import com.dalgim.namespace.personservice.general.GetPersonInfoRequest;
import com.dalgim.namespace.personservice.general.GetPersonInfoResponse;
import com.dalgim.sample.soap.domain.Person;
import com.dalgim.sample.soap.endpoint.mapper.CreatePersonRequestMapper;
import com.dalgim.sample.soap.endpoint.mapper.CreatePersonResponseMapper;
import com.dalgim.sample.soap.endpoint.mapper.GetPersonInfoResponseMapper;
import com.dalgim.sample.soap.service.PersonGateway;
import org.springframework.beans.factory.annotation.Autowired;
import javax.jws.WebService;

/**
 * Created by dalgim on 26.03.2017.
 */
@WebService(endpointInterface = "com.dalgim.namespace.personservice.PersonService", serviceName = "PersonService")
public class PersonServiceEndpoint implements PersonService {

    private PersonGateway personGateway;
    private GetPersonInfoResponseMapper getPersonInfoResponseMapper;
    private CreatePersonRequestMapper createPersonRequestMapper;
    private CreatePersonResponseMapper createPersonResponseMapper;

    @Override
    public GetPersonInfoResponse getPersonInformation(GetPersonInfoRequest personInfoRequest) {
        return personGateway.findPersonByLogin(personInfoRequest.getLogin())
                .map(getPersonInfoResponseMapper::map)
                .orElse(null);
    }

    @Override
    public CreatePersonResponse createPerson(CreatePersonRequest createPersonRequest) {
        Person person = createPersonRequestMapper.map(createPersonRequest);
        return createPersonResponseMapper.map(personGateway.createPerson(person));
    }

    @Autowired
    public void setPersonGateway(PersonGateway personGateway) {
        this.personGateway = personGateway;
    }

    @Autowired
    public void setGetPersonInfoResponseMapper(GetPersonInfoResponseMapper getPersonInfoResponseMapper) {
        this.getPersonInfoResponseMapper = getPersonInfoResponseMapper;
    }

    @Autowired
    public void setCreatePersonRequestMapper(CreatePersonRequestMapper createPersonRequestMapper) {
        this.createPersonRequestMapper = createPersonRequestMapper;
    }

    @Autowired
    public void setCreatePersonResponseMapper(CreatePersonResponseMapper createPersonResponseMapper) {
        this.createPersonResponseMapper = createPersonResponseMapper;
    }
}

