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

import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.JFrame;

public class Game extends Observable
{
	private Deck deck;
	protected Board board;
	private Dice dice;
	protected ArrayList<Player> players;
	protected Player currentPlayer;
	protected Player opponent;
	private int numArmies;
	protected Country enemyCountry;
	protected boolean attack;
	protected boolean fortify;
	protected Country playerCountry;
	protected int[] playerNumbers;
	protected int[] enemyNumbers;
	
	/**
	*Constructor that takes countries, continents and adjacencies filenames and a list of the players
	**/
	public Game(String countries, String continents, String adjacencies, ArrayList<Player> players) throws Exception
	{
		board = new Board();
		board.loadBoard(countries, continents, adjacencies);
		deck = new Deck();
		deck.shuffle();
		dice = new Dice();
		this.players = players;
		playerCountry = new Country(null);
		currentPlayer = new Player(null, 0);
		opponent = new Player(null, 0);
		numArmies = 0;
		playerNumbers = new int[2];
		enemyNumbers = new int[2];
		enemyCountry = new Country(null);
		attack  = false;
		fortify = false;
	}
	
	/**
	*sets the initial number of armies for the players
	**/
	public void initializePlayers()
	{
		int numArmies = 0;
		if(players.size()==3)
		{numArmies = 35;}
		else
		if(players.size()==4)
		{numArmies = 30;}
		else
		if(players.size()==5)
		{numArmies =  25;}
		else 
		if(players.size()==6)
		{numArmies =  20;}
		
		for(Player player : players)
		{
			player.numberArmies = numArmies;
		}
		
	}
	
	/**
	*gives the highest index to determine who begins the game
	**/
	public int beginByRolling()
	{
		int[] numbers = dice.rollDice(players.size());
		int highest= numbers[0];
		int highestIndex = 0;
		for(int i=0; i<numbers.length; i++)
		{
			if(highest<numbers[i])
			{
				highest = numbers[i];
				highestIndex = i;
			}
		}
		return highestIndex;
	}

	/**
	*method that sets the next player
	**/
	public void nextPlayer()
	{
		int x = players.indexOf(currentPlayer);
		currentPlayer= players.get((x+1)%players.size());
		setChanged();
		notifyObservers();
	}
	
	/**
	*method that selects first player so that he can start adding countries
	**/
	public void addCountries()
	{
		this.initializePlayers();
		int number = this.beginByRolling();
		currentPlayer = players.get(number);
		setChanged();
		notifyObservers();
		
	}
	
	/**
	*method that sets the players values after being changed
	**/
	public void setPlayerValues()
	{
		for(int i=0; i<players.size();i++)
		{
			if(players.get(i).name.equals(currentPlayer.name))
			{players.set(i, currentPlayer);}
			
			if(players.get(i).name.equals(opponent.name))
			{players.set(i,opponent);}		
		}
		setChanged();
		notifyObservers();	
	}


	/**
	*method that calculates the number of armies gained at the beginning of each turn
	**/
	public int ArmiesGained()
	{
		int numArmiesGain = 3;
		if(currentPlayer.getCountries().size()>9)
		{
			numArmiesGain = currentPlayer.getCountries().size()/3;
		}
		
		for(int i=0; i <currentPlayer.getContinents().size(); i++)
		{
			String name = currentPlayer.getContinents().get(i).getName();
			if(name.equals("North America"))
			{
				numArmiesGain+=5;		
			}
			else if(name.equals("South America"))
			{
				numArmiesGain+=2;
			}
			else if(name.equals("Africa"))
			{
				numArmiesGain+=3;
			}
			else if(name.equals("Europe"))
			{
				numArmiesGain+=5;
			}
			else if(name.equals("Asia"))
			{
				numArmiesGain+=7;
			}
			else if(name.equals("Australia"))
			{	
				numArmiesGain+=2;
			}
		}
		return numArmiesGain;
	}
	
	/**
	*method that asks user whether he wants to attack or not
	**/
	public boolean attackOrNot()
	{
		return attack;  //gets the decision to attack or not from the gui
	}
	
	/**
	*method that gets the number of dice to be rolled by a player
	**/
	public int getNumDice(Player player)
	{
		int numberOfDice = 0;
		if(player==currentPlayer)
		{
			int x = playerCountry.getNumArmies();
			System.out.println(x);
			if(x>3)
			{
				numberOfDice = 3;
			}
			else if(x==3)
			{
				numberOfDice = 2;
			}
			else if(x==2)
			{
				numberOfDice = 1;
			}
		}
		else 	
		if(player==opponent)
		{
			int x = enemyCountry.getNumArmies();
			System.out.println(x);
			if(x>=2)
			{
				numberOfDice = 2;
			}
			else if(x==1)
			{
				numberOfDice = 1;
			}
		}
		//number of armies in country must be greater than the number of dice rolled
		return numberOfDice;			
	}
	/**
	*method that allows the user to attack
	**/
	public void attack()
	{
		int num = currentPlayer.getCountries().size();
		if(attackOrNot())
		{
			int playerDice = this.getNumDice(currentPlayer);
			int enemyDice = this.getNumDice(opponent);
			playerNumbers = dice.highestNumbers(dice.rollDice(playerDice));
			enemyNumbers = dice.highestNumbers(dice.rollDice(enemyDice));
			setChanged();
			notifyObservers();
		
			if(playerCountry.getNumArmies()>1 && playerCountry.getAdjacencies().contains(enemyCountry))
			{
				if(playerNumbers[0]>enemyNumbers[0])
				{
					enemyCountry.setNumArmies(enemyCountry.getNumArmies()-1);
				}
				if(playerNumbers[0]<=enemyNumbers[0])
				{
					playerCountry.setNumArmies(playerCountry.getNumArmies()-1);
				}
	

				if(enemyCountry.getNumArmies()==0)
				{
					enemyCountry.setNumArmies(playerDice);
					opponent.removeCountry(enemyCountry.getName());
					currentPlayer.addCountry(enemyCountry);
				}
				if(playerCountry.getNumArmies()>1)
				{
				
				if((Integer)playerNumbers[1]!=null && (Integer)enemyNumbers[1]!=null && playerNumbers[1]>enemyNumbers[1])
				{
					enemyCountry.setNumArmies(enemyCountry.getNumArmies()-1);
				}
				else if((Integer)playerNumbers[1]!=null && (Integer)enemyNumbers[1]!=null && playerNumbers[1]<=enemyNumbers[1])
				{
					playerCountry.setNumArmies(playerCountry.getNumArmies()-1);
				}
				}
				if(enemyCountry.getNumArmies()== 0)
				{
					enemyCountry.setNumArmies(playerDice);
					opponent.removeCountry(enemyCountry.getName());
					currentPlayer.addCountry(enemyCountry);
				}
				if(opponent.getNumArmies()==0)
				{
					if(opponent.riskCards!=null){
					currentPlayer.riskCards.addAll(opponent.riskCards);
					opponent.riskCards = null;
					players.remove(opponent);}
				}
				this.setPlayerValues();
			}
		}
		
		if(num<currentPlayer.getCountries().size())
		{
			currentPlayer.addRiskCard(deck.draw());
		}
			
	}
	
	/**
	*method that asks user whether to fortify or not
	**/
	public boolean fortifyOrNot()
	{
		return fortify; //will get the user's choice from the gui	
	}
	/**
	*method that allows the user to fortify one of his countries
	**/
	public void fortify()
	{
		this.nextPlayer();
	}
}	
