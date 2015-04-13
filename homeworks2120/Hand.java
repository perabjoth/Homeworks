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

public class Hand
{

	private ArrayList<Card> deck;

	/**
	* No-arg constructor. Instantiate Deck.
	**/
	public Hand()
	{
		deck = new ArrayList<Card>();
	}

	/**
	* Adds the card to the hand 
	**/
	public void add(Card card)
	{
		deck.add(card);
	}
	/**
	* Removes the cards at the given indices from the hand
	**/
	public ArrayList<Card> removeCardsFromHand(int index1, int index2, int index3)
	{
		Card card1 = deck.get(index1);
		Card card2 = deck.get(index2);
		Card card3 = deck.get(index3);
		deck.remove(card1);
		deck.remove(card2);
		deck.remove(card3);
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(card1);
		cards.add(card2);
		cards.add(card3);
		return cards;
	}

	/**
	* returns true if the player can turn in cards
	**/
	public boolean canTurnInCards()
	{
		int matchingCardsInfantry = 0;
		int matchingCardsCavalry = 0;
		int matchingCardsArtillery = 0;
		for(int i=0;i<deck.size()-1;i++)
		{
			for(int x =i+1; x<deck.size();i++)
			{
				if(deck.get(i).getType().equals(deck.get(x).getType()) && deck.get(x).equals("Infantry"))
				{
					matchingCardsInfantry++;
				}
			
				if(deck.get(i).getType().equals(deck.get(x).getType()) && deck.get(x).equals("Cavalry"))
				{
					matchingCardsCavalry++;
				}

				if(deck.get(i).getType().equals(deck.get(x).getType()) && deck.get(x).equals("Artillery"))
				{
					matchingCardsArtillery++;
				}
		
			}
		
		}//checking if there are three cards of same type
		int infantry = 0;
		int cavalry = 0;
		int artillery = 0;
		for(int i=0; i<deck.size();i++)
		{
			if(deck.get(i).getType().equals("Infantry"))
			{
				infantry++;			
			}
			if(deck.get(i).getType().equals("Cavalry"))
			{
				cavalry++;			
			}
			if(deck.get(i).getType().equals("Artillery"))
			{
				artillery++;			
			}
		}//checking the number of cards for each type
		if(matchingCardsInfantry>=3||matchingCardsCavalry>=3||matchingCardsArtillery>=3)//true if player has three or more of the same type
		{
			return true;		
		}
		else 
		if(infantry>=1 && cavalry>=1 && artillery>=1)
		{
			return true;			
		}//true if playes has one or more of each type of card
		else if(deck.size()>4)
		return true;//true if player has 5 or more cards
		else
		{
			return false;//false which means cards can't be turned in
		}
	}

	/**
	* Returns true if the player must turn in cards
	**/
	public boolean mustTurnInCards()
	{
		if(deck.size()>4)
		{
			return true;			
		}
		else
		{
			return false;		
		}
	}

	/**
	* Returns the hand
	**/
	public ArrayList<Card> getHand()
	{
		return deck;
	}
}
