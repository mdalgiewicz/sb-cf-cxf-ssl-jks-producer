package com.dalgim.sample.soap.config;

import com.dalgim.namespace.personservice.PersonRegistry;
import com.dalgim.namespace.personservice.PersonRegistryService;
import com.dalgim.sample.soap.endpoint.PersonRegistryImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import javax.xml.ws.Endpoint;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Mateusz Dalgiewicz on 26.03.2017.
 */
@Configuration
public class WebServiceConfig {

    private static final String SERVLET_URL_PATH = "/api";
    private static final String SERVICE_URL_PATH = "/PersonSoapService_1.0";

    @Bean
    public ServletRegistrationBean cxfServlet() {
        return new ServletRegistrationBean(new CXFServlet(), SERVLET_URL_PATH + "/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public PersonRegistry personRegistry() {
        return new PersonRegistryImpl();
    }

    @Bean
    public PersonRegistryService personRegistryService() {
        return new PersonRegistryService();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), personRegistry());
        endpoint.setServiceName(personRegistryService().getServiceName());
        endpoint.setWsdlLocation(personRegistryService().getWSDLDocumentLocation().toString());
        endpoint.publish(SERVICE_URL_PATH);
        return endpoint;
    }
}
