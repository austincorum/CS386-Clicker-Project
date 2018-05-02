package nau.cs386.Clicker;

import static org.junit.Assert.*;
import org.junit.Test;

class clickerTester {
	
	Counter clicker;
	
	@Test
	void testClickerCreatingNull() {
		clicker = new Counter(0,0);
		assertEquals(0, clicker.getCount());
		assertEquals(0, clicker.getModifier());
	}
	
	@Test
	void testClickerCreatingNonNull() {
		clicker = new Counter(1,10);
		assertEquals(1, clicker.getCount());
		assertEquals(10, clicker.getModifier());
	}
	
	@Test
	void testClickerCounting() {
		clicker = new Counter(0,0);
		for(int i = 0; i<10; i++) {
			clicker.countIncriment(1);
		}
		assertEquals(10, clicker.getCount());
	}

}
