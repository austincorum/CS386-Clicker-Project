package nau.cs386.Clicker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {
	// This tests to see if the autoClicker function is actual manipulating the counter
	
	@DisplayName("Checks to see if the auto object has the ability to manipulate the counter's variables")
	@Test
	void testAutoandClicker() 
	{
		ClickerRunner counterRunner = new ClickerRunner();
		Counter counter = counterRunner.initializeCounter();
		AutoClicker auto = new AutoClicker(counter);
		int before = auto.countMe.count;
		
		auto.countMe.countIncriment(1);
		counterRunner.saveAndQuit(counter);
		
		assertTrue(counter.getCount() > before);
	}
	
	@DisplayName("Tests to see if the saving function still works after the autoclicker changes the counter")
	@Test
	void testSaveMethod() 
	{
		ClickerRunner counterRunner = new ClickerRunner();
		Counter counter = counterRunner.initializeCounter();
		AutoClicker auto = new AutoClicker(counter);
		
		auto.countMe.countIncriment(1);
		 int old = auto.countMe.getCount();
		 counterRunner.saveAndQuit(counter);
		 int next = counterRunner.initializeCounter().getCount();
		 
		 assertEquals(old, next);
	}
	
	@DisplayName("Tests to see if the Window can initialize the list of jokes and vars in JokeRunner class")
	@Test
	void testWindowJRunner() 
	{
		Window w = new Window(0,0,"TEST",new Game());
		assertFalse(w.laughs.jokeList.isEmpty()); // checks window init
		
		for(int i = 0; i < w.laughs.jokeNum; i++)
		{
			assertEquals(w.laughs.jokeList.get(w.laughs.jokeIndex), w.laughs.jokeList.get(i)); // checks variable init 
			w.laughs.jokeIndex++;
		}
	}
}
