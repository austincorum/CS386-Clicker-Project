package nau.cs386.Clicker;

public class AutoClicker implements Runnable {
	Counter countMe;
	Boolean keepClicking;
	
	public AutoClicker( Counter counter )
	{
		this.countMe = counter;
		this.keepClicking = false;
	}
	
	public void run()
	{
		this.keepClicking = true;
		
		while(this.keepClicking)
		{
			try
			{
				Thread.sleep(1000);
			} 
			catch(Exception e){}
			this.countMe.countIncriment(1);
		}
	}
}
