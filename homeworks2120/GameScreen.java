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
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import javax.swing.JLabel;
import java.io.IOException;
import javax.swing.JComponent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;
import java.util.Vector;
import java.awt.FlowLayout;
import javax.swing.BoxLayout ;

public class GameScreen extends JFrame  implements Observer
{

	private BufferedImage map;//image of map
	private ImageComponent imageComponent;//displaying map
	private JPanel bottomPanel;//the panel set at the bottom
	private JButton turnInCards;//button to turn in cards
	private JLabel playerHand;//Jlabel showing the player's cards
	private JPanel sidePanel;//panel set to the right side
	private JButton placeTroops;//button to place troops
	private JButton attack;//button to attack
	private JButton fortify;//button to fortify
	private JLabel mouseMoved;//Jlabel showing the movement of the mouse
	private Dimension screenSize;//screensize
	private JComboBox menu;//menu to save or quit game
	private JLabel territory;//Jlabel to select territory
	private JComboBox placeOver;////choose where to place troops
	private JLabel troops;//JLabel to select troops
	private JComboBox playerTroops;//choose troops
	private JLabel myTerritory;//jlabel indicating player's territory
	private JComboBox myTerritories;//choose territory from which to attack from
	private JLabel enemyTerritory;//Jlabel indicating opponent's territories
	private JComboBox enemyTerritories;//choose territory to attack
	private JLabel cards;//jlabel indicating the player's cards
	private JList playerCards;//choose card
	private JComboBox reinforce;//which country to reinforce
	private JLabel reinforceCountry;//jlabel indicating country to be reinforced
	private JFrame frame;//extra frame for popup messages
	private JButton start;
	private String currentPlayer;
	private JLabel playerName;
	private Game game;
	private JPanel leftPanel;
	private JList countries;
	private ArrayList<String> countryNames; 
	private Country currentCountry;
	private Vector names;
	private ArrayList<Country> playerCountries;
	private String [] countriesOfPlayer;
	private String[] cardsInGame;
	private ArrayList<Country> enemyCountries;
	private String[] countriesOfEnemy;
	private JLabel numOfArmies;
	private int [] playerDice;
	private JLabel playerNumbers;
	private int[] enemyDice;
	private JLabel enemyNumbers;
	/**Contructor for the method which sets the initial frame to be fullscreen and initializes all neccessary variable for proper functioning
	*of the class
	**/
	public GameScreen(Game privateGame)
	{
		super("Risk");
		setUndecorated(true);
		setLayout(new BorderLayout());
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize);
		setResizable(false);
		setVisible(true);
		game = privateGame;
		playerDice = game.playerNumbers;
		enemyDice = game.enemyNumbers;
		playerNumbers = new JLabel("Player got "+ playerDice[0] + " & " + playerDice[1]);
		enemyNumbers = new JLabel("Enemy got " + enemyDice[0] + " & " + enemyDice[1]);
		numOfArmies= new JLabel("You have " + game.currentPlayer.getNumArmies() + " left.");
		currentCountry = new Country(null);
		countryNames = new ArrayList<String>();
		for(int i =0;i<42;i++)
		{
			if(game.board.getCountries().get(i).getOccupant()==null)
			countryNames.add(game.board.getCountries().get(i).getName());			
		}
		names = new Vector(countryNames);
		countries = new JList(names);
		frame = new JFrame();
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setSize(150, 190);
		frame.setResizable(false);
		currentPlayer = game.currentPlayer.name;
		playerName = new JLabel("Current Player: " + currentPlayer);
		leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		leftPanel.add(playerName);
		leftPanel.add(numOfArmies);
		cards = new JLabel("Hold CTRL and \nselect cards using mouse:");
		playerCountries = game.currentPlayer.getCountries();
		countriesOfPlayer = new String[playerCountries.size()];
		for(int i =0; i<playerCountries.size(); i++)
		{
			countriesOfPlayer[i] = playerCountries.get(i).getName();
		}
		String[] options = {"Save Game", "Quit"};
		ArrayList<Card> cardsOfPlayer = game.currentPlayer.riskCards;
		cardsInGame = new String[cardsOfPlayer.size()];
		for(int i = 0;i<cardsOfPlayer.size(); i++)
		{
			cardsInGame[i] = cardsOfPlayer.get(i).getType();
		}
		reinforce = new JComboBox(countriesOfPlayer);
		reinforce.setSelectedItem(null);
		reinforceCountry = new JLabel("Choose which country to reinforce");
		playerCards = new JList(cardsInGame);
		playerCards.setLayoutOrientation(JList.VERTICAL);
		playerCards.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		menu = new JComboBox(options);
		menu.addActionListener(new MenuListener());
		mouseMoved = new JLabel();
		addMouseMotionListener(new MouseHandler());
		sidePanel = new JPanel();
		sidePanel.setLayout(new FlowLayout());
		bottomPanel = new JPanel();
		playerHand = new JLabel("Risk Hand");
		turnInCards = new JButton("Turn In Cards");
		turnInCards.addActionListener(new HandTurnIn());
		turnInCards.setEnabled(false);
		placeTroops = new JButton("Place Reinforcements");
		placeTroops.addActionListener(new TroopPlacer());
		placeTroops.setEnabled(false);
		start = new JButton("Start Game");
		start.addActionListener(new Starter());
		attack = new JButton("Attack");
		myTerritory = new JLabel("Choose Where \nTo Attack From:");
		myTerritories = new JComboBox(countriesOfPlayer);
		myTerritories.setSelectedItem(null);
		enemyTerritory = new JLabel("Choose Where To Attack:");
		enemyCountries = game.opponent.getCountries();
		countriesOfEnemy = new String[enemyCountries.size()];
		for(int i = 0; i<enemyCountries.size(); i++)
		{
			countriesOfEnemy[i] = enemyCountries.get(i).getName();
		}
		enemyTerritories = new JComboBox(countriesOfEnemy);
		enemyTerritories.setSelectedItem(null);
		fortify = new JButton("Fortify");
		fortify.addActionListener(new Fortifier());
		attack.addActionListener(new Attacker());
		attack.setEnabled(false);
		fortify.setEnabled(false);
		territory = new JLabel("Choose Territory:");
		placeOver = new JComboBox(countriesOfPlayer);
		placeOver.setSelectedItem(null);
		troops = new JLabel("Choose Troops:");
		String[] dummyTroops = {"Infantry", "Cavalry", "Artillery"};
		playerTroops = new JComboBox(dummyTroops);
		playerTroops.setSelectedItem(null);
		bottomPanel.add(mouseMoved);
		bottomPanel.add(start);
		bottomPanel.add(playerHand);
		bottomPanel.add(turnInCards);
		bottomPanel.add(placeTroops);
		bottomPanel.add(attack);
		bottomPanel.add(fortify);
		add(menu, BorderLayout.NORTH);
		add(leftPanel, BorderLayout.WEST); 
		try{map = ImageIO.read(new File("RiskBoard3.jpeg"));}
		catch(IOException e)	
		{System.out.println("Image not found" + e);}
		imageComponent = new ImageComponent();
		getContentPane().add(imageComponent);
		add(bottomPanel, BorderLayout.SOUTH);
		add(sidePanel, BorderLayout.EAST);
		setVisible(true);
		game.addObserver(this);
	}
	public void update(Observable obs, Object obj){
		currentPlayer = game.currentPlayer.name;
		numOfArmies.setText("You have " + game.currentPlayer.getNumArmies() + " armies left.");
		playerName.setText("Current Player: " + currentPlayer);
		playerCountries = game.currentPlayer.getCountries();
		playerDice = game.playerNumbers;
		enemyDice = game.enemyNumbers;
		ArrayList<Integer> numbers1 = new ArrayList<Integer>();
		ArrayList<Integer> numbers2 = new ArrayList<Integer>();
		for(int i=0;i<playerDice.length;i++)
		{
			numbers1.add(playerDice[i]);		
		}
		for(int i=0; i<enemyDice.length; i++)
		{
			numbers2.add(enemyDice[i]);	
		}
		playerNumbers.setText("Player got "+ numbers1);
		enemyNumbers.setText("Enemy got " +numbers2);
		setVisible(true);
	}
	private class Starter implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
			game.addCountries();
			String displayMessage = ("The first turn goes to: " + currentPlayer + " since he got the highest number when the die were rolled\n Now each Player will choose his country starting with " + currentPlayer);
			JOptionPane.showMessageDialog(frame, displayMessage);
			countries.setLayoutOrientation(JList.VERTICAL);
			CountryListener listener = new CountryListener();
			countries.addListSelectionListener(listener);	
			leftPanel.add(countries);
			setVisible(true);
			start.setVisible(false);
		}
	}
	
	private class CountryListener implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent event)
				{
					
					String item = (String) countries.getSelectedValue();
					if (item != null && !item.equals("")){
					currentCountry = game.board.getCountryByName((String)((JList)event.getSource()).getSelectedValue());
					game.playerCountry = currentCountry;
					game.currentPlayer.addCountry(currentCountry);
					currentCountry.setNumArmies(currentCountry.getNumArmies()+1);
					game.currentPlayer.decrementArmies(1);
					game.setPlayerValues();
					game.nextPlayer();
					names.remove(currentCountry.getName());
					countries.setListData(names);
					setVisible(true);
					}
					if(countries.getModel().getSize()==0)
					placeTroops.setEnabled(true);
				}
	}
	
	
	/**An ActionListener class for the menu which will be displayed at the top of the screen**/
	private class MenuListener implements ActionListener
	{	
		public void actionPerformed(ActionEvent event)
		{
			JComboBox box = (JComboBox)event.getSource();
			String source = (String)box.getSelectedItem();
			if(source.equals("Save Game"))
			{
				JOptionPane.showMessageDialog(frame, "Game Saved");
				frame.setVisible(true);
			}
			else if(source.equals("Quit"))
			{
				JOptionPane.showMessageDialog(frame, "Game Quitting");
				frame.setVisible(true);
				System.exit(0);
			
			
			}
	
		}
	
	
	
	}
	/**An ActionListener class that allows the player to place his/her troops on the map**/
	private class TroopPlacer implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
			sidePanel.removeAll();
			playerTroops.setSelectedItem(null);
			playerTroops.addActionListener(new Placer());
			sidePanel.add(troops);
			sidePanel.add(playerTroops);
			setVisible(true);
			placeTroops.setEnabled(false);
			
		}
	
	}
	/**An ActionListener class that allows the player to place his/her troops on the map**/
	private class Placer implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
			if(playerTroops.getSelectedItem()!=(null))
			{	
				sidePanel.removeAll();
				placeOver.removeAllItems();
				for(int i = 0; i<playerCountries.size(); i++){
				placeOver.addItem( playerCountries.get(i).getName());
				}
				placeOver.addActionListener(new Popup());
				placeOver.setSelectedItem(null);
				if(game.currentPlayer.getNumArmies()>0){
				sidePanel.add(territory);
				sidePanel.add(placeOver);}
				else{attack.setEnabled(true);}
				setVisible(true);			
			}
		}
	}
	/**An ActionListener class that pops up a message showing where the player wants to place his troops**/
	private class Popup implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(placeOver.getSelectedItem()!=(null))
			{
				String displayMessage = "You chose to place " + (String)playerTroops.getSelectedItem()+" on " + (String)placeOver.getSelectedItem();
				if((String)playerTroops.getSelectedItem()=="Infantry" && game.currentPlayer.getNumArmies()>=1)
				{
					game.currentPlayer.decrementArmies(1);
					Country chosen = game.board.getCountryByName((String)placeOver.getSelectedItem());
					chosen.setNumArmies(chosen.getNumArmies()+1);
				}
				else
				if((String)playerTroops.getSelectedItem()=="Cavalry"&& game.currentPlayer.getNumArmies()>=5)
				{
					game.currentPlayer.decrementArmies(5);
					Country chosen = game.board.getCountryByName((String)placeOver.getSelectedItem());
					chosen.setNumArmies(chosen.getNumArmies()+5);
				}
				else
				if((String)playerTroops.getSelectedItem()=="Artillery"&& game.currentPlayer.getNumArmies()>=10)
				{
					game.currentPlayer.decrementArmies(10);
					Country chosen = game.board.getCountryByName((String)placeOver.getSelectedItem());
					chosen.setNumArmies(chosen.getNumArmies()+10);
				}
				else{JOptionPane.showMessageDialog(frame, "Not enough troops available!");
				frame.setVisible(true);}
				JOptionPane.showMessageDialog(frame, displayMessage);//displaying message
				playerTroops.setSelectedItem(null);//resetting all variables
				placeOver.setSelectedItem(null);
				for(ActionListener al : playerTroops.getActionListeners())
				{	
					playerTroops.removeActionListener(al);				
				}
				for(ActionListener al : placeOver.getActionListeners())
				{	
					placeOver.removeActionListener(al);				
				}
				sidePanel.removeAll();	
				attack.setEnabled(true);
			}			
		}		
		

	}
	/**An ActionListener class to fortify territories with troops**/
	private class Fortifier implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int x =0;
			for(Player player : game.players)
			{
				x = x +player.getNumArmies();
			}
			if(x == 0)
			{
				
			
				for(ActionListener al : playerTroops.getActionListeners())
					{	
						playerTroops.removeActionListener(al);				
					}
				sidePanel.removeAll();
				playerTroops.setSelectedItem(null);
				sidePanel.add(troops);
				sidePanel.add(playerTroops);
				playerTroops.addActionListener(new FortificationPopup());
				reinforce.removeAllItems();
				for(int i = 0; i<playerCountries.size(); i++){
				reinforce.addItem( playerCountries.get(i).getName());
				}
				reinforce.setSelectedItem(null);
				reinforce.addActionListener(new FortificationPopup());
				sidePanel.add(reinforceCountry);
				sidePanel.add(reinforce);
			}
			else
			{JOptionPane.showMessageDialog(frame, "You did not attack!");
			}
			
				setVisible(true);
				fortify.setEnabled(false);
				game.fortify();
				placeTroops.setEnabled(true);
			
		}
	}
	/**An ActionListener class that shows which territory was fortified**/
	private class FortificationPopup implements ActionListener
	{	
		public void actionPerformed(ActionEvent event)
		{
			if(playerTroops.getSelectedItem()!= null && reinforce.getSelectedItem()!= null)
			{
				String displayMessage = "You selected to reinforce "+ (String)reinforce.getSelectedItem()+" with " + (String)playerTroops.getSelectedItem();
				JOptionPane.showMessageDialog(frame, displayMessage);//displaying message
				playerTroops.setSelectedItem(null);//resetting all elements
				reinforce.setSelectedItem(null);
				for(ActionListener al : playerTroops.getActionListeners())
				{	
					playerTroops.removeActionListener(al);				
				}
				for(ActionListener al : reinforce.getActionListeners())
				{	
					reinforce.removeActionListener(al);				
				}
				sidePanel.removeAll();				
			}
		}	
	
	}
	/**A MouseMotionListener class that shows the location of the mouse**/
	private class MouseHandler implements MouseMotionListener
	{
		public void mouseMoved(MouseEvent event)
		{
		mouseMoved.setText(event.getX()+", "+ event.getY());//displaying mouse coordinates
		if(playerCards.getModel().getSize()>=3)
		turnInCards.setEnabled(true);
		setVisible(true);	
		}
		public void mouseDragged(MouseEvent event)
		{}
		
	
	}
	/**An ActionListener class that will allow user to turn in cards**/
	private class HandTurnIn implements ActionListener
	{
	
		public void actionPerformed(ActionEvent event)
		{
				sidePanel.removeAll();
				sidePanel.add(cards);
				//cardsInGame = new String[cardsOfPlayer.size()];
				//for(int i = 0;i<cardsOfPlayer.size(); i++)
				//{
				//	cardsInGame[i] = cardsOfPlayer.get(i).getType();
				//}
				playerCards.addListSelectionListener(new CardShower());
				sidePanel.add(playerCards);			
				setVisible(true);
		}
	
	}
	/**An ActionListener class that shows which card the user is turning in**/
	private class CardShower implements ListSelectionListener
	{
		public void valueChanged(ListSelectionEvent event)
		{
			if(playerCards.getValueIsAdjusting()== false)
			{
				if(playerCards.getSelectedValuesList().size()==3){
				String displayMessage= "You chose to turn in " + playerCards.getSelectedValuesList();
				JOptionPane.showMessageDialog(frame, displayMessage);//displaying message
				playerCards.clearSelection();//resetting all elements
				for(ListSelectionListener al : playerCards.getListSelectionListeners())
				{	
					playerCards.removeListSelectionListener(al);				
				}
				sidePanel.removeAll();
				}
			}	
			
		}	
	}
	/**An ActionListener class that allows the user to attack territories**/
	private class Attacker implements ActionListener
	{
	
		public void actionPerformed(ActionEvent event)
		{
			int x =0;
			for(Player player : game.players)
			{
				x = x +player.getNumArmies();
			}
			if(x == 0)
			{
				
				leftPanel.add(playerNumbers);
				leftPanel.add(enemyNumbers);
				setVisible(true);
				
					for(ActionListener al : playerTroops.getActionListeners())
					{	
						playerTroops.removeActionListener(al);				
					}
					sidePanel.removeAll();	
					playerTroops.setSelectedItem(null);
					myTerritories.removeAllItems();
					for(int i = 0; i<playerCountries.size(); i++){
					if(playerCountries.get(i).getNumArmies()>1)
					myTerritories.addItem( playerCountries.get(i).getName());
					}
					myTerritories.setSelectedItem(null);
					enemyTerritories.setSelectedItem(null);
					myTerritories.addActionListener(new AttackPopup());
					enemyTerritories.addActionListener(new AttackPopup());
					playerTroops.addActionListener(new AttackPopup());
					sidePanel.add(myTerritory);
					sidePanel.add(myTerritories);
					sidePanel.add(enemyTerritory);
					sidePanel.add(enemyTerritories);	
					sidePanel.add(troops);		
					sidePanel.add(playerTroops);
					setVisible(true);
				
			}
			else
			{JOptionPane.showMessageDialog(frame, "Not all troops have been deployed!");
				frame.setVisible(true);}
				attack.setEnabled(false);
				fortify.setEnabled(true);
		}
	
	}
	/**An ActionListener class that shows which territory has been attacked**/
	private class AttackPopup implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(myTerritories.getSelectedItem()!=null && enemyTerritories.getSelectedItem()== null)
			{
				enemyTerritories.removeAllItems();
				String countryName = (String)myTerritories.getSelectedItem();
				ArrayList<Country> enemyCountries = game.board.getAdjacencies(countryName);
				for(int i = 0; i<enemyCountries.size(); i++){
				if(enemyCountries.get(i).getOccupant().name != currentPlayer)
				enemyTerritories.addItem( enemyCountries.get(i).getName());
				}
				setVisible(true);
			}
			if(myTerritories.getSelectedItem()!=(null) && enemyTerritories.getSelectedItem()!=(null) && playerTroops.getSelectedItem()!=(null))
			{
				game.enemyCountry = game.board.getCountryByName((String)enemyTerritories.getSelectedItem());
				game.opponent = game.board.getCountryByName((String)enemyTerritories.getSelectedItem()).getOccupant();
				game.playerCountry = game.board.getCountryByName((String)myTerritories.getSelectedItem());

				String displayMessage = "You chose to attack " + (String)playerTroops.getSelectedItem() + " from " + (String)myTerritories.getSelectedItem()+ " to " + (String)enemyTerritories.getSelectedItem();
				JOptionPane.showMessageDialog(frame, displayMessage);//displaying message
				int attackOrNot = JOptionPane.showConfirmDialog(frame,"Would you like to attack?", "Risk: Attacking",JOptionPane.YES_NO_OPTION);
				if(attackOrNot==JOptionPane.YES_OPTION)
				game.attack = true;
				else
				game.attack=false;
				
				game.attack();
				playerTroops.setSelectedItem(null);//resetiing all variables
				myTerritories.setSelectedItem(null);
				enemyTerritories.setSelectedItem(null);
				for(ActionListener al : playerTroops.getActionListeners())
				{	
					playerTroops.removeActionListener(al);				
				}
				for(ActionListener al : myTerritories.getActionListeners())
				{	
					myTerritories.removeActionListener(al);				
				}
				for(ActionListener al : enemyTerritories.getActionListeners())
				{	
					enemyTerritories.removeActionListener(al);				
				}
				sidePanel.removeAll();
				
			}		
		}	
	
	}
	/**A JComponent class in order to display the image in the JFrame**/
	public class ImageComponent extends JComponent
	{
		private BufferedImage image;
		public ImageComponent()
		{	
			image = map;
			repaint();
		}
		
		public void paintComponent(Graphics g)
		{
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			g.drawImage(image, 100, 100,screenSize.width-200,screenSize.height-200, this);//drawing image withing logical size of screen
		}
	
	
	}
}
