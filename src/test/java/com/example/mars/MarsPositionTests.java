package com.example.mars;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MarsPositionTests {

	@Test
	public void testTurn() throws Exception {
        MarsPosition p = new MarsPosition(0, 0, 'N');
        p.turnLeft();
		Assert.assertEquals('W', p.getDir());
        p.turnRight();
        Assert.assertEquals('N', p.getDir());
	}
}
