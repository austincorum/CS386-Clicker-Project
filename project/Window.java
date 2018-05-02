package nau.cs386.Clicker;

import java.awt.event.*;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/**
 * Creates the new window for game and all JFrame code
 */
public class Window extends Canvas {
	//package requirement
	private static final long serialVersionUID = 2728619292569729565L;
	private static final Color mainColor = Color.BLUE;
	private static final Color accColor = Color.YELLOW;
	JokeRunner laughs;
	
	// Constructor
	public Window(int width, int height, String title, Game game)
	{
		/*Counter/ClickerRunner provided by Gavin Incorporated and AutoClicker provided by Alex Analytics*/
		ClickerRunner clicker = new ClickerRunner();
	    Counter counter = clicker.initializeCounter();
	   	AutoClicker autoClicker = new AutoClicker(counter);
	   	laughs = new JokeRunner();
	   
	   	/*
     	* JFrame Decelerations
     	* */  
		//Framework
	    JFrame frame = new JFrame(title); // create frame
	   	GroupLayout layout = new GroupLayout(frame.getContentPane());
	   	frame.getContentPane().setLayout(layout);
	   	// Panels
	   	JPanel panel = new JPanel();
		JPanel titlepanel = new JPanel();
		JPanel Btnpanel = new JPanel(new GridLayout(1,3));
		// Create Labels
		JLabel titlelabel = new JLabel("", SwingConstants.CENTER);
		JLabel scorelabel = new JLabel("Score: " + counter.getCount());
		// Create Buttons
		JButton mainBtn = new JButton("Gain Respect");
		JButton exitBtn = new JButton("QUIT");
		JButton autoBtn = new JButton("Start Auto Clicking");
		JButton shopBtn = new JButton("Respect Store");
		
		mainBtn.setFont(new java.awt.Font("Arial", Font.BOLD, 18));
		exitBtn.setFont(new java.awt.Font("Arial", Font.BOLD, 18));
		autoBtn.setFont(new java.awt.Font("Arial", Font.BOLD, 18));
		shopBtn.setFont(new java.awt.Font("Arial", Font.BOLD, 18));
		
		mainBtn.setBackground(Color.BLUE);
		exitBtn.setBackground(Color.BLUE);
		autoBtn.setBackground(Color.BLUE);
		shopBtn.setBackground(Color.BLUE);
		
		mainBtn.setForeground(Color.YELLOW);
		exitBtn.setForeground(Color.YELLOW);
		autoBtn.setForeground(Color.YELLOW);
		shopBtn.setForeground(Color.YELLOW);
		
		//Set Framework size and color
		titlepanel.setSize(100,100);
		panel.setSize(WIDTH,HEIGHT);
		frame.setVisible(true);
		//Button Dimensions
		Dimension d = new Dimension(20,10);
		mainBtn.setPreferredSize(d);
		exitBtn.setPreferredSize(d);
		autoBtn.setPreferredSize(d);
		autoBtn.setPreferredSize(d);
		//Fonts
		Font font1 = new Font("Veranda",Font.PLAIN, 20); // make a bigger font for the score
		Font titleFont = new Font("Veranda",Font.ITALIC, 100);
		
		/*
		 * 			 Layout V and H 
		 *  This is the required way to add the objects to the Outer GroupLayout
		 ***********************************************************************/
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(titlepanel)
				.addComponent(Btnpanel)
				.addComponent(panel)
				);
		layout.setHorizontalGroup(layout.createParallelGroup()
				.addComponent(panel)
				.addComponent(titlepanel)
				.addComponent(Btnpanel)
				);
		/****************************************************************/
		
		frame.add(game); // Must add Game: otherwise we will lose the game instance after 1 render loop
		/*
		 * Creating the Frame details
		 * */
		// Add objects to the Panels 		
		titlepanel.add(Box.createHorizontalStrut(50));
		titlepanel.add(titlelabel);
		titlepanel.add(Box.createHorizontalStrut(50));
		titlepanel.add(scorelabel);
		
		panel.add(new JLabel(new ImageIcon("./assets/doerryHeadshot.jpg")));
		
		Btnpanel.add(mainBtn);
		Btnpanel.add(exitBtn);
		Btnpanel.add(autoBtn);
		Btnpanel.add(shopBtn);

		/*
		 * Creates labels*/
		titlelabel.setFont(titleFont);
		titlelabel.setText("<html><h1><strong><i>Death by Dr. D</i></strong></h1></html>");
		scorelabel.setFont(font1);
		//Set Colors
		Btnpanel.setBackground(accColor);
		titlepanel.setBackground(accColor);	
		titlelabel.setForeground(mainColor);
		panel.setBackground(mainColor);
		
	/****************************************
	* THESE LINES MUST BE BELOW THE JFRAME FORMAT CODE
	****************************************/
		 /* Setting the dimensions of the game as well as closing op*/
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		frame.setLocationRelativeTo(null);// Just better for testing: not needed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//safety net for closing game
		frame.setResizable(false);
	/*******************************************/	
		
		/*
		 * Action Listeners*/
		mainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(autoClicker.keepClicking == false)
				{
					counter.countIncriment(counter.getModifier());
					scorelabel.setText("Score: " + counter.getCount());
			        if((counter.getCount()) % 100 == 0 && (counter.getCount() != 0))
			        {
			        	//check to see if we are on the last joke: if so loop to the first.
			        	if(laughs.jokeIndex == laughs.jokeNum)
			        	{
			        		laughs.jokeIndex = 0;
			        	}
			        	new Joke("JOKE INITIATED",laughs.jokeList.get(laughs.jokeIndex),laughs.jokeNum);
			        	laughs.jokeIndex++;
			        }
				}
				else
				{/*do nothing b/c autoClicker is working*/}
			}
		});
		// This section was created using the AutoClicker Class made by Alex
		autoBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(autoClicker.keepClicking == false)
				{
					autoBtn.setText("Auto Clicking");
					autoBtn.setForeground(accColor);
					autoBtn.setBackground(Color.RED);
					new Thread(autoClicker).start();
					scorelabel.setText("Score: "+ autoClicker.countMe.getCount());
				}
				else if(autoClicker.keepClicking)
				{
					autoClicker.keepClicking = false;
					scorelabel.setText("Score: " + counter.count);
					autoBtn.setText("Start Auto Clicking");
					autoBtn.setBackground(mainBtn.getBackground());
					autoBtn.setForeground(mainBtn.getForeground());
				}
			}
		});
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				clicker.saveAndQuit(counter);
				System.exit(0);
			}
		});
		
		shopBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(!autoClicker.keepClicking)
				{
					new Shop(counter);
				}	
			}
		});
		game.start(counter, scorelabel);
	}
}
