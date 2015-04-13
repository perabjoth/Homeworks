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
public class PlayerScreen extends JFrame
{
	private JComboBox numOfPlayers;//combo box to select number of players
	private JLabel forNum;//Jlabel telling person to select number of players
	protected int number;//number of players
	protected PlayerInitiation screen;//the screen that will ask for each player's info
	/**Contructor that sets the initial frame size and intializes all neccessary variables**/
	public PlayerScreen()
	{
		super("Risk");
		number = 0;
		screen = new PlayerInitiation();
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize(350, 100);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//getting screensize
		this.setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);//putting the frame in the middle
		setResizable(false);//can't change the size
		setVisible(true);

		forNum = new JLabel("Select number of Players:");
		add(forNum);

		setLayout(new FlowLayout());

		String [] choices = {"3","4","5","6"};//choices for number of players
		numOfPlayers = new JComboBox(choices);
		numOfPlayers.setMaximumRowCount(3);//maximum number of rows to be displayed

		ComboListener listener = new ComboListener();

		numOfPlayers.addActionListener(listener);

		add(numOfPlayers);
	}
	/**returning the number of players**/
	public int getNum()
	{
		return number;
	}
	/**an ActionListener class that sets the number of players and displays the next screen**/
	private class ComboListener implements ActionListener{
		public void actionPerformed(ActionEvent event)
			{	
					
					number = numOfPlayers.getSelectedIndex() + 3;//setting the number of players by getting index and adding 3
					setVisible(false);//disabling the visibility of this screen 
					screen.setIterations(number);
					screen.initialize();
					screen.setVisible(true);//showing the new screen
					
			}		
		}
				
}
