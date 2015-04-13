/**
* Name: Perabjoth Singh Bajwa
* ID:2449713
* CSCI 2120 Spring 2014
* Game of Risk
*      ******
*    **********
*   *************
*  ***************
*  **   *****  ***
*  ***************
*   ****** ******
*    ***********
*     *********
*    ***********
*   ************* 
**/  
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;	
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import java.util.ArrayList;

public class PlayerInitiation extends JFrame
{
	
	private int iterations;//number of players
	private JLabel playerName;//asking player for his/her name
	private JTextField [] name;//input field for name
	private JLabel colorSelection;//asking player to choose color
	private JComboBox [] colors;//color choices
	protected String [] playerNames;//player names
	private String [] colorOfPlayer;//player colors
	protected GameScreen gameScreen;
	/**setting the intial frame size and intializing all neccessary variables to store data of players**/
	public PlayerInitiation()
	{
		super("Risk");
		setLayout(new FlowLayout());
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize(350, 550);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//getting screensize
		this.setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);//setting frame in the middle
		setResizable(false);//size can not be changed
		playerName = new JLabel();
		name = new JTextField[0];
		colorSelection = new JLabel();
		colors = new JComboBox[0];
		playerNames = null;
		colorOfPlayer = new String[0];
		iterations  = 0;
		gameScreen = null;
	}
	/**method to set number of iterations which will be the number of players**/
	public void setIterations(int num)
	{
		iterations = num;
	}
	
	/**method that takes displayes the neccessary GUI to take input from the user**/
	public void initialize()
	{
		
		name = new JTextField[iterations];
		for(JTextField text : name)
		text = new JTextField(null);
		colors = new JComboBox[iterations];
		String [] playerColor = {"Blue","Green","Red","Yellow","Orange","Black"};//colors to be chosen
		NameSaver listener = new NameSaver();
		JLabel instructions1 = new JLabel("PRESS ENTER AFTER ENTERING EVERY NAME");//giving instructions
		instructions1.setForeground(Color.red);
		add(instructions1);
		JLabel instructions2 = new JLabel("AND CLICK ON THE COLOR THE PLAYER WANTS");//giving instructions
		instructions2.setForeground(Color.red);
		add(instructions2);
		JLabel instructions3 = new JLabel("GAME BEGINS UPON ENTERING LAST PLAYER'S NAME");//giving instructions
		instructions3.setForeground(Color.red);
		add(instructions3);
		for(int i = 0; i<iterations; i++)//for loop that displays input fields for number of players
		{
			int index = i+1;
			colorSelection = new JLabel("Choose Player " + index + "'s color:");
			add(colorSelection);
			colors[i] = new JComboBox(playerColor);
			colors[i].setSelectedItem(null);
			add(colors[i]);
			playerName = new JLabel("Insert Player " + index + "'s name:");
			add(playerName);
			name[i] = new JTextField(null, 20);
			add(name[i]);
			name[i].addActionListener(listener);
			setVisible(true);
			colors[i].addActionListener(listener);
		}
		
	}
	/**method to set the names of the players**/
	public void setNames()
	{
		playerNames = new String[iterations];
		for(int i= 0; i<iterations; i++)
		{
			playerNames[i] = name[i].getText();
			System.out.println(playerNames[i]);//just to be sure everything is functioning properly	
		}
			
	
	}
	/**method to set the colors of the players**/
	public void setColors()
	{
		colorOfPlayer = new String[iterations];
		for(int i= 0; i<iterations; i++)
		{
			colorOfPlayer[i] = (String)colors[i].getSelectedItem();
			System.out.println(colorOfPlayer[i]);//just to be sure everything is functioning properly
		}
		
	}
	
	/**an ActionListener class that sets the names and colors of the player**/
	private class NameSaver implements ActionListener
	{
	
		public void actionPerformed(ActionEvent event)
		{
			setNames();
			setColors();
			if((event.getSource().equals(name[iterations-1]) || event.getSource().equals(name[iterations-2]) ||event.getSource().equals(name[iterations-3])) && !playerNames[iterations-1].equals("") && !playerNames[iterations-2].equals("") && !playerNames[iterations-3].equals("") && colorOfPlayer[iterations-1]!=null && colorOfPlayer[iterations-2]!=null&&colorOfPlayer[iterations-3]!=null)//once all fields 
			{
				setVisible(false);
				ArrayList<Player> players = new ArrayList<Player>();
				for(int i =0; i<playerNames.length;i++)	
				{
					Player player = new Player(playerNames[i], 0);
					players.add(player);
				}

				try
				{
					Game game = new Game("countries.txt", "continents.txt", "adjacencies.txt",players );
					gameScreen = new GameScreen(game);//initializing game
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		}
	
	}	
}
		
