package com.dalgim.sample.soap.endpoint;

import com.dalgim.namespace.personservice.PersonService;
import com.dalgim.namespace.personservice.general.GetPersonInfo;
import com.dalgim.namespace.personservice.general.GetPersonInfoResponse;

import javax.jws.WebService;

/**
 * Created by dalgim on 26.03.2017.
 */
@WebService(endpointInterface = "com.dalgim.namespace.personservice.PersonService", serviceName = "PersonService")
public class PersonServiceEndpoint implements PersonService {

    @Override
    public GetPersonInfoResponse getPersonInformation(GetPersonInfo parameters) {
        return null;
    }
}
