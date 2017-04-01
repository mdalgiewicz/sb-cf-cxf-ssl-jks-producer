package com.dalgim.sample.soap;

import com.dalgim.sample.soap.config.WebServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({WebServiceConfig.class})
@EnableAutoConfiguration
public class CxfContractFirstSoapProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CxfContractFirstSoapProducerApplication.class, args);
	}
}
