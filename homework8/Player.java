/**
* Name (ID) : Perabjoth Singh Bajwa (2449713)
*Friday, December 6, 2013
*1583/1581 fall 2013
*Homework 8: BlackJack (Player class)
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
import java.util.Scanner;
public class Player

{

	private Card[] hand;//array holding the cards that the player has in his hands
	private int numberOfCards;//number of cards that the player has
		
	private Strategy myStrategy;//the strategy the player will use to play the game
	
	private int sum;//the sum of the value of the cards
	public Player(int value)
	{
		numberOfCards =0 ;
		
		sum = 0;
		hand = new Card[26];//assigned 26 empty slots because the user will not need anymore

		
		if(value ==1)
		{
		myStrategy = new TimidStrategy();
	
		}
		else if(value == 2)
		{
		myStrategy = new AggressiveStrategy();
		
		}
		else if(value == 3)
		{
		myStrategy = new DealerStrategy();
		
		}//assigning user's strategy according to input
	}
	public void giveCard(Card newCard)
	{	
		
		
		this.hand[numberOfCards] = newCard;//adding a new card to the cards that the player has
		this.sum = this.sum + newCard.value();//adding the value of the new card to the value of the cards already in player's hand
		numberOfCards++;//increasing number of cards by 1 
	}

	public Card[] playerCards()
	{
		Card[] allCards = this.hand;//copying array of cards that the player has
		return allCards ;
	
	}

	public int takeTurn()
	{
		return this.myStrategy.hitOrStand(handValue());	//returning a 1 or 0 based on the player's strategy to determine whether to hit or stand
	}
	public int handValue()
	{
		return this.sum;//sum of value of cards
	}
	public void allCards()
	{	
		
		Card[] allCards = playerCards();
		for(int i=0; allCards[i]!=null; i++)
		{
			System.out.println("\n"+allCards[i].toString());		
		}//printing out all cards the user has
		
	}
	public int numberOfCards()
	{
		int x = numberOfCards;
		return x;//returing the number of cards the user has
			
	}

}
