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
import java.io.ObjectInputStream;
import java.io.File;
import java.util.Scanner;
import java.util.Collections;
public class Deck
{

	private ArrayList<Card> deck;
	private ArrayList<Country> countries;
	/**
	* Creates all 42 cards, one for each territory. Each card has either 
	* a type of Infantry, Cavalry, or Artillery. Ensure that the number of
	* Ifantry, Cavalry, and Artillery are the same
	**/
	public Deck()
	{
		countries = new ArrayList<Country>();
		try{
			Scanner fileReader = new Scanner(new File("countries.txt"));
			while(fileReader.hasNextLine())
			{
				countries.add(new Country(fileReader.nextLine().trim()));
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
		deck = new ArrayList<Card>();
		for(int i = 0; i<42 ; i++)//setting an even number of cards for each type of army
		{
			deck.add(new Card("Infantry",countries.get(i)));
			i++;
			deck.add(new Card("Cavalry",countries.get(i)));
			i++;
			deck.add(new Card("Artillery",countries.get(i)));
		}
	}

	/**
	* Removes a card from the deck and return it
	**/
	public Card draw()
	{
		Card drawnCard = deck.get((deck.size()-1));
		deck.remove((deck.size()-1));
		return drawnCard;
	}

	/**
	* Add a card to the deck
	**/
	public void add(Card card)
	{
		deck.add(card);
		
	}

	/**
	* Shuffle the deck of cards
	**/
	public void shuffle()
	{
		Collections.shuffle(deck);
	}

}
