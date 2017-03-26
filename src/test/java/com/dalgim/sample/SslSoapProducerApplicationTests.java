package com.dalgim.sample;

import com.dalgim.sample.soap.SslSoapProducerApplication;
import com.dalgim.sample.soap.service.PersonGateway;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SslSoapProducerApplication.class)
public class SslSoapProducerApplicationTests {

	@Autowired
	private PersonGateway personGateway;

	@Test
	public void contextLoads() {
		personGateway.getAllPersons();
		System.out.println();
		assert true;
	}

}
