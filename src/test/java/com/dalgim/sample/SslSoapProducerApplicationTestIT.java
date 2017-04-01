package com.dalgim.sample;

import com.dalgim.sample.soap.CxfContractFirstSoapProducerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CxfContractFirstSoapProducerApplication.class)
public class SslSoapProducerApplicationTestIT {

	@Test
	public void contextLoads() {
		assert true;
	}

}
