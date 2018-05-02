package nau.cs386.Clicker;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * JFrame Parts for each joke window*/

public class Joke extends Canvas
{
	/*
	 * package requirement*/
	private static final long serialVersionUID = -5952453780568433919L;
	
	private String joke = "NO JOKE FOR YOU";

	public Joke(String title,String joke, int jokeNum)
	{
		this.joke = joke;
		
		JFrame jokeWindow = new JFrame(title); // create frame
		JPanel jokeBox = new JPanel();
		JLabel jokeLabel = new JLabel(this.joke);
		JButton exitBtn = new JButton("Laugh");

		if(this.isVisible()) // if the window is visible that means its a joke so we will display
		{	
			//Dimensions of Window
			int w = 400,h = 625;

			/* Make Things visible */
			jokeWindow.setVisible(true);
			jokeBox.setVisible(true);
			jokeLabel.setVisible(true);
			exitBtn.setVisible(true);
			
			//This is a work around for a bug: it's allowing HTML format to read the \n character
			jokeLabel.setText("<html>" + this.joke.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
	
			// Window
			jokeWindow.setSize(w, h);
			
			// Panel's Box
			jokeBox.setBackground(Color.darkGray);
			jokeBox.setSize(w/3, h/3);
			jokeBox.setLocation(w/2, h/2);
			
			//Label
			jokeLabel.setForeground(Color.WHITE);
			jokeLabel.setVerticalTextPosition(3);
			
			//Button
			exitBtn.setSize(80, 30);
			exitBtn.setLocation(160,550);
		
			// Add to Frame
			jokeBox.add(jokeLabel);
			jokeBox.add(new JLabel(new ImageIcon("./assets/SmileyDoerry.jpg")));
			jokeWindow.add(exitBtn);
			jokeWindow.add(jokeBox);
			
			// Set Location and Close Operation
			jokeWindow.setLocationRelativeTo(null);
			jokeWindow.setResizable(false);
			jokeWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // allows for this window to close separately from the rest of the program
			
			//Close if the Button is pushed
			exitBtn.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e)
				{
					jokeWindow.dispose();
				}
			});
		}
	}
}
