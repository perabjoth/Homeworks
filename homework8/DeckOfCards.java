/**
* Name (ID) : Perabjoth Singh Bajwa (2449713)
*Friday, December 6, 2013
*1583/1581 fall 2013
*Homework 8: BlackJack (Deck of Cards class)
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
import java.util.Random;
public class DeckOfCards
{	
	private Card[] cards;//creating an array of cards
	

	public DeckOfCards()
	{
		cards = new Card[52];//deck of cards consisting of 52 cards
		for(int i = 0 ; i<cards.length; i++)
		{
			cards[i] = new Card(i+1);//giving the card values from 1 to 52
			
		}
		

	}
	
	public void shuffle()
	{
		
		Random shufflingNumber = new Random();//random number generator
		
		
		for(int counter = 0; counter < this.cards.length ; counter++)
		{
			int number = shufflingNumber.nextInt(this.cards.length); //generating a number from 0 to the number of cards in the deck
			Card temp = this.cards[counter];//temporary card holding value of current card			
			this.cards[counter] = this.cards[number];//giving current card new random card value
			this.cards[number] = temp;//swapping the cards
		}
		
	}
	public Card draw()
	{
		Card drawnCard;
		drawnCard = this.cards[0];//drawing the card from the top of the deck
		Card[] newDeck = new Card[this.cards.length-1];//new deck smaller than original deck by 1
		for(int i = 0; i < newDeck.length; i++)
		{
			newDeck[i] = this.cards[i+1];//copying all elements of original deck except first card
		}
		this.cards = newDeck;//new deck is old deck without the drawn card
		return drawnCard;//the card that has been drawn
	}

}
