package com.dalgim.sample.soap.config;

import com.dalgim.namespace.personservice.Person;
import com.dalgim.namespace.personservice.PersonService;
import com.dalgim.sample.soap.endpoint.PersonServiceEndpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import javax.xml.ws.Endpoint;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dalgim on 26.03.2017.
 */
@Configuration
public class WebServiceConfig {

    private static final String SERVLET_URL_PATH = "/api";
    private static final String SERVICE_URL_PARH = "/PersonSoapService_1.0";

    @Bean
    public ServletRegistrationBean cxfServlet() {
        return new ServletRegistrationBean(new CXFServlet(), SERVLET_URL_PATH + "/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public PersonService personService() {
        return new PersonServiceEndpoint();
    }

    @Bean
    public Person person() {
        return new Person();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), personService());
        endpoint.setServiceName(person().getServiceName());
        endpoint.setWsdlLocation(person().getWSDLDocumentLocation().toString());
        endpoint.publish(SERVICE_URL_PARH);
        return endpoint;
    }
}
