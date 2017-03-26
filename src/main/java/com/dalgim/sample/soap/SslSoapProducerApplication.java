package com.dalgim.sample.soap;

import com.dalgim.sample.soap.config.AppConfig;
import com.dalgim.sample.soap.config.WebServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
		AppConfig.class,
		WebServiceConfig.class
})
@EnableAutoConfiguration
public class SslSoapProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslSoapProducerApplication.class, args);
	}
}
