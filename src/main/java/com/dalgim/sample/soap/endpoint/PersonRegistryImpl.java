package com.dalgim.sample.soap.endpoint;

import com.dalgim.namespace.personservice.PersonRegistry;
import com.dalgim.namespace.personservice.general.CreatePersonRequest;
import com.dalgim.namespace.personservice.general.CreatePersonResponse;
import com.dalgim.namespace.personservice.general.GetAllPersonInfoResponse;
import com.dalgim.namespace.personservice.general.GetPersonInfoRequest;
import com.dalgim.namespace.personservice.general.GetPersonInfoResponse;
import com.dalgim.namespace.personservice.general.Void;
import com.dalgim.sample.soap.domain.Person;
import com.dalgim.sample.soap.endpoint.mapper.CreatePersonRequestMapper;
import com.dalgim.sample.soap.endpoint.mapper.CreatePersonResponseMapper;
import com.dalgim.sample.soap.endpoint.mapper.GetAllPersonInfoResponseMapper;
import com.dalgim.sample.soap.endpoint.mapper.GetPersonInfoResponseMapper;
import com.dalgim.sample.soap.service.PersonGateway;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import javax.jws.WebService;
import java.util.Collection;

/**
 * Created by Mateusz Dalgiewicz on 26.03.2017.
 */
@WebService(
        targetNamespace = "http://www.dalgim.com/namespace/personservice/",
        serviceName = "PersonRegistry")
public class PersonRegistryImpl implements PersonRegistry {

    private PersonGateway personGateway;
    private GetPersonInfoResponseMapper getPersonInfoResponseMapper;
    private CreatePersonRequestMapper createPersonRequestMapper;
    private CreatePersonResponseMapper createPersonResponseMapper;
    private GetAllPersonInfoResponseMapper getAllPersonInfoResponseMapper;

    @Override
    public GetPersonInfoResponse getPersonInfo(GetPersonInfoRequest getPersonInfoRequest) {
        Preconditions.checkNotNull(getPersonInfoRequest, "GetPersonInfoRequest cannot be null!");

        return personGateway.findPersonByLogin(getPersonInfoRequest.getLogin())
                .map(getPersonInfoResponseMapper::map)
                .orElse(null);
    }

    @Override
    public CreatePersonResponse createPerson(CreatePersonRequest createPersonRequest) {
        Preconditions.checkNotNull(createPersonRequest, "CreatePersonRequest cannot be null!");

        Person createdPerson = personGateway.createPerson(createPersonRequestMapper.map(createPersonRequest));
        return createPersonResponseMapper.map(createdPerson);
    }

    @Override
    public GetAllPersonInfoResponse getAllPersonInfo(Void getAllPersonInfoRequest) {
        Collection<Person> allPersons = personGateway.getAllPersons();
        return getAllPersonInfoResponseMapper.map(allPersons);
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

    @Autowired
    public void setGetAllPersonInfoResponseMapper(GetAllPersonInfoResponseMapper getAllPersonInfoResponseMapper) {
        this.getAllPersonInfoResponseMapper = getAllPersonInfoResponseMapper;
    }
}

