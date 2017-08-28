package junittest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestUnit
{
	@Test
	public void testAdd()
	{
		int value1 = 2;
		int value2 = 3;
		
		assertEquals(value1 + value2, 5);
		
	}
}
