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
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFileChooser;

public class MainMenu extends JFrame
{
	private JButton newGame;
	private JButton loadGame;
	private JButton quit;
	protected PlayerScreen screen;
	private JFileChooser chooser;
	/**Constructor setting up initial frame size and initializing all neccessary variables**/
	public MainMenu()
	{
		super("Risk");
		setLayout(new FlowLayout(20,20,20));
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize(150, 190);
		setResizable(false);
		setVisible(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//getting screensize
		this.setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);//setting frame in the middle of the screen
		newGame = new JButton("New Game");
		loadGame = new JButton("Load Game");
		quit = new JButton("   Quit   ");
		add(newGame);
		add(loadGame);
		add(quit);
		screen = null;
		chooser = null;
		ButtonHandler handler = new ButtonHandler();
		newGame.addActionListener(handler);
		loadGame.addActionListener(handler);
		quit.addActionListener(handler);
	}
	
	/**An ActionListener class that allows the user to begin a new game, load a saved game or quit**/
	private class ButtonHandler implements ActionListener
	{
		
		public void actionPerformed(ActionEvent event)
		{
			String name;
			name = event.getActionCommand();//getting the source of the event
			if(name.equals("New Game"))
			{
				screen = new PlayerScreen();//screen to ask number of players
				setVisible(false);
			}
			if(name.equals("Load Game"))
			{
				chooser = new JFileChooser();
				int returnVal = chooser.showOpenDialog(null);

				loadGame.setText("Clicked");
			}
			if(name.equals("   Quit   "))
			{
				System.exit(0);//quits the game
			}
		}

	
	}

}

