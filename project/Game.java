package nau.cs386.Clicker;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JLabel;

/**
 * 
 * @author Multiple Contributors: 
 * @version 1.2
 **/

/*
 *	Game()
 * This is the starter class, it also helps to create the window and rendering system
 * All it does is start the main program window and continue to refresh the screen
 */

public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 3997411633843547825L;
	/*
	 * package requirement*/
	private static final int WIDTH= 800, HEIGHT = WIDTH/12*9; // define the dimensions of the Window
	public final Color mainColor = Color.BLUE;
	private Thread thread; // create thread for Game
	private boolean running = false;
	private Counter counter;
	private JLabel scoreLabel;
	
	public Game()
	{
		new Window(WIDTH, HEIGHT, "Death by Dr.D",this); // create the Window Object
	}
	
	// tell java that the thread is on with variable: Boolean running
	public synchronized void start(Counter counter, JLabel scoreLabel)
	{
		this.counter = counter;
		this.scoreLabel = scoreLabel;
		thread = new Thread(this);
		thread.start(); //start the new thread
		running = true;
	}
	
	public synchronized void stop()
	{
		try {
			running = false; // stop running
			thread.join(); // rejoin
			
		}catch(Exception e)
		{
			e.printStackTrace();// catch any problem
		}
	}
	
	public void run()
	{
		long lastTime = System.nanoTime(); // save the system timer in nanoseconds
		double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks; // target frame rate turned into nanoseconds
		double delta = 0;
		long timer = System.currentTimeMillis(); //current time in milliseconds
		int frames = 0;
		
		/************************************************
		 * This loop takes the current runtime in nano 
		 * and the last elapse of the loop's time in nano.
		 * It then checks to see if the system has been running
		 *  for a second and if it hasn't it loops again.
		 *  But if it has been a second it will render the next frame.
		 * *************************************************************/
		while(running)
		{
			long now = System.nanoTime(); 
			delta += (now - lastTime)/ns; 
			lastTime = now;
			while(delta >= 1) 
			{
				tick();
				delta--; 
			}
			if(running)
			{
				render(); 
			}
			frames++;
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
				scoreLabel.setText("Score: "+ counter.getCount());
			}
		}
		/****************end while loop**************************/
		stop();
	}
	
	// do nothing
	private void tick(){}
	
	/*
	 * BufferStrategy helps organize the Canvas and Window*/
	private void render()
	{
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null)
		{
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(mainColor);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		g.dispose();
		bs.show();
	}
	
	/**
	 *  THIS STARTS THE PROGRAM NOW
	 * */
	public static void main(String args[])
	{
		new Game(); // start the game
	}
}
