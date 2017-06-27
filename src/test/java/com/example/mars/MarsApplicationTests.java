package com.example.mars;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MarsApplicationTests {

	@Autowired
    private MarsController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private void testExample(String cmd, String result) throws Exception {
        assertThat(
        	this.restTemplate.getForObject("http://localhost:" + port + "/rest/mars/" + cmd, String.class))
        	.contains(result);    	
    }

    @Test
    public void examplesAreOk() throws Exception {
    	testExample("MMRMMRMM", "(2, 0, S)");
    	testExample("MML", "(0, 2, W)");    	
    }
}
