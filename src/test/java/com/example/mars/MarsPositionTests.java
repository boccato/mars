package com.example.mars;

import org.junit.Assert;
import org.junit.Test;

public class MarsPositionTests {

	@Test
	public void testTurn() throws Exception {
        MarsPosition p = new MarsPosition(0, 0, 'N');
        p.turnLeft();
		Assert.assertEquals('W', p.getDir());
        p.turnRight();
        Assert.assertEquals('N', p.getDir());
    }

    @Test
    public void testTurn360() throws Exception {
        // Turning 4 times to the same side gets you back where you were.
        for (char c : "NSWE".toCharArray()) {
            MarsPosition p = new MarsPosition(0, 0, c);
            
            for (int i=0;i<4;i++) {
                p.turnLeft();
            }
            Assert.assertEquals(c, p.getDir());

            for (int i=0;i<4;i++) {
                p.turnRight();
            }
            Assert.assertEquals(c, p.getDir());
        }
	}

    @Test
    public void testTurn270() throws Exception {
        for (char c : "NSWE".toCharArray()) {
            MarsPosition p90 = new MarsPosition(0, 0, c);
            MarsPosition p270 = new MarsPosition(0, 0, c);

            for (int i=0;i<3;i++) {
                p270.turnLeft();
            }
            p90.turnRight();

            Assert.assertEquals(p90.getDir(), p270.getDir());
        }
    }
        
}
