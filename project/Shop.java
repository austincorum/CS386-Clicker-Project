package nau.cs386.Clicker;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

 /**
 * This framework works along side the ShopRunner Class to create the store window
 */

/*
 * JFrame Parts for the window*/
public class Shop extends Canvas
{
	/*
	 * package requirement*/
	private static final long serialVersionUID = -4833300353445075335L;
	private String header = "<html><h1><strong><i>Welcome to the Dr. D Store</i></strong></h1></html>";
	
	public Shop(Counter counter)
	{
		/*
		 * JFramer parts*/
		JFrame shopWindow = new JFrame("Dr. D Store"); // create frame
		JPanel OuterContainer = new JPanel(new GridLayout(5,1));
		JPanel titleBox = new JPanel(new FlowLayout());
		JPanel nameBox = new JPanel(new GridLayout(1,3));
		JPanel buttonBox = new JPanel(new GridLayout(1,3));
		JPanel descBox = new JPanel(new GridLayout(1,3));
		JPanel endBox = new JPanel(new GridLayout());
		JLabel Label = new JLabel(this.header);
		JLabel pwrLabel1 = new JLabel("<html>This is power-up cost 150 pts and<br/>it will boost your points<br/>per click by 10.</html>",SwingConstants.CENTER);
		JLabel pwrLabel2 = new JLabel("<html>This is power-up cost<br/>500 pts and it will boost<br/>your points per click by 20.</html>",SwingConstants.CENTER); // descriptions will be hard coded using html once we decide what they do
		JLabel pwrLabel3 = new JLabel("<html>This is power-up cost 1000 pts and<br/>it will boost your points<br/>per click by 50.</html>",SwingConstants.CENTER);
		JLabel pwr1Name = new JLabel("Lvl 1 Power-up",SwingConstants.CENTER); // these will also be hard coded
		JLabel pwr2Name = new JLabel("Lvl 2 Power-up",SwingConstants.CENTER);
		JLabel pwr3Name = new JLabel("Lvl 3 Power-up",SwingConstants.CENTER);
		JButton exitBtn = new JButton("Close");
		JButton Pwr1Btn = new JButton("Purchase?");
		JButton Pwr2Btn = new JButton("Purchase?");
		JButton Pwr3Btn = new JButton("Purchase?");
		// this must be added first so lets do it now
		shopWindow.add(OuterContainer);
		// if the window is visible that means we should see shop
		if(this.isVisible()) 
		{	
			//Dimensions of Window
			int w = 600,h = 450;
			/* Make Things visible */
			OuterContainer.setVisible(true);
			shopWindow.setVisible(true);
			buttonBox.setVisible(true);
			Label.setVisible(true);
			exitBtn.setVisible(true);
			// Window settings
			shopWindow.setLocationRelativeTo(null);
			shopWindow.setResizable(false);
			shopWindow.setSize(w, h);
			// Box color and border settings
			buttonBox.setBackground(Color.BLUE);
			buttonBox.setBorder(BorderFactory.createCompoundBorder());
			titleBox.setBackground(Color.YELLOW);
			descBox.setBackground(Color.BLUE);
			nameBox.setBackground(Color.BLUE);
			//Labels
			Label.setVerticalTextPosition(3);
			//Component Colors
			Label.setForeground(Color.BLUE);
			pwr1Name.setForeground(Color.YELLOW);
			pwr2Name.setForeground(pwr1Name.getForeground());
			pwr3Name.setForeground(pwr1Name.getForeground());
			pwrLabel1.setForeground(pwr1Name.getForeground());
			pwrLabel2.setForeground(pwr1Name.getForeground());
			pwrLabel3.setForeground(pwr1Name.getForeground());
			Pwr1Btn.setBackground(Color.YELLOW);
			Pwr1Btn.setForeground(Color.BLUE);
			Pwr2Btn.setBackground(Pwr1Btn.getBackground());
			Pwr2Btn.setForeground(Pwr1Btn.getForeground());
			Pwr3Btn.setBackground(Pwr1Btn.getBackground());
			Pwr3Btn.setForeground(Pwr1Btn.getForeground());
			exitBtn.setBackground(Pwr1Btn.getBackground());
			exitBtn.setForeground(Pwr1Btn.getForeground());
			// Add objects to Boxes
			titleBox.add(Label);
			buttonBox.add(Pwr1Btn);
			buttonBox.add(Pwr2Btn);
			buttonBox.add(Pwr3Btn);
			descBox.add(pwrLabel1);
			descBox.add(pwrLabel2);
			descBox.add(pwrLabel3);
			nameBox.add(pwr1Name);
			nameBox.add(pwr2Name);
			nameBox.add(pwr3Name);
			endBox.add(exitBtn);
			// Add  boxes to Frame
			OuterContainer.add(titleBox);
			OuterContainer.add(nameBox);
			OuterContainer.add(buttonBox);
			OuterContainer.add(descBox);
			OuterContainer.add(endBox);
			//Close Operation (Dispose)
			shopWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
			
			//Close if the Button is pushed
			exitBtn.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e)
				{
					shopWindow.dispose();
				}
			});
			
			Pwr1Btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					if(counter.getCount() >= 150)
					{
						counter.purchase(150,10);
					}
				}
			});
			
			Pwr2Btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					if(counter.getCount() >= 500)
					{
						counter.purchase(500,20);
					}
				}
			});
			
			Pwr3Btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e)
				{
					if(counter.getCount() >= 1000)
					{
						counter.purchase(1000,30);
					}
					
				}
			});
		}
	}
}
