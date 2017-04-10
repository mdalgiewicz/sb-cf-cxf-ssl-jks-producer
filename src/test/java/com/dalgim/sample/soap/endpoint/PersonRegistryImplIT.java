package com.dalgim.sample.soap.endpoint;

import com.dalgim.namespace.personservice.PersonRegistry;
import com.dalgim.namespace.personservice.general.CreatePersonRequest;
import com.dalgim.namespace.personservice.general.CreatePersonResponse;
import com.dalgim.sample.soap.CxfContractFirstSoapProducerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by Mateusz Dalgiewicz on 01.04.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(
        classes=CxfContractFirstSoapProducerApplication.class,
        webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT,
        properties = { "server.port:8093"})
public class PersonRegistryImplIT {

    @Autowired
    private PersonRegistry personRegistry;
    @Value("${classpath:requests/CreatePersonRequest.xml}")
    private Resource createPersonRequestXml;

    @Test
    public void createPersonTest() throws Exception {

        //given
        CreatePersonRequest createPersonRequest = new CreatePersonRequest();
        createPersonRequest.setFirstname("John");
        createPersonRequest.setLogin("Smith");
        createPersonRequest.setLogin("John.Smith");
        createPersonRequest.setPassword("P@ssw0rd");

        //when
        CreatePersonResponse createPersonResponse = personRegistry.createPerson(createPersonRequest);

        //then
        assertNotNull(createPersonResponse);
        assertNotNull(createPersonResponse.getPersonInfo());
        assertEquals(createPersonResponse.getPersonInfo().getFirstname(), createPersonRequest.getFirstname());
        assertEquals(createPersonResponse.getPersonInfo().getLastname(), createPersonRequest.getLastname());
        assertEquals(createPersonResponse.getPersonInfo().getLogin(), createPersonRequest.getLogin());
        assertEquals(createPersonResponse.getPersonInfo().getPassword(), createPersonRequest.getPassword());
        assertNotNull(createPersonResponse.getPersonInfo().getId());
    }

}
