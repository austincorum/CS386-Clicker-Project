package nau.cs386.Clicker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/* 
 * this is the rendering backbone for the joke windows
 * it used the same idea as the main window but we won't need a new thread*/
public class JokeRunner
{
	private String FILENAME = "jokes.txt";
	
	/*
	 * Declare Variables for use throughout the entirety of the game*/
	int jokeNum = 0;
	int jokeIndex = 0;
	ArrayList<String> jokeList = new ArrayList<String>();
	
	//Constructor
	public JokeRunner(){
		//Init Jokes list
		this.JokeInit(FILENAME);
	}
	
	//Reads file and initializes the ArrayList
	public void JokeInit(String file)
	{
		try {
			FileInputStream in = new FileInputStream(file);
			Scanner fileReader = new Scanner(in);
			while(fileReader.hasNextLine())
			{
				String temp1 = fileReader.nextLine();
				String temp2 = fileReader.nextLine();
				
				try {
					@SuppressWarnings("unused")
					String xtraline = fileReader.nextLine();// get rid of extra lines if they exist
				}catch(Exception e) {}
				this.jokeList.add(temp1.toString() +"\n"+ temp2.toString());
				this.jokeNum++;
			}
			fileReader.close();
		}catch (FileNotFoundException e){e.printStackTrace();}
	}// end JokeInit
} // end class
