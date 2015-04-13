/**
* Name (ID) : Perabjoth Singh Bajwa (2449713)
*Friday, December 6, 2013
*1583/1581 fall 2013
*Homework 8: BlackJack 
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
public class BlackJack

{

	private DeckOfCards myDeck;//creating a deck of cards

	private Player dealer;//creating a dealer

	private Player player;//creating a player
	
	public BlackJack()
	{
		myDeck = new DeckOfCards();
		dealer = new Player(3);//dealer 
		player = new Player(1);//player
	}

	public void playRound()
	{
		boolean repeatLoop = true;

		int strategy;//number for strategy

		Scanner input = new Scanner(System.in);

		System.out.println("\nHow would you like to play: \n\n1)Timid\n\n2)Aggressive\n\nInsert number of choice:\n");
		strategy = input.nextInt();//user inputing the choice for strategy
		
		while(repeatLoop)
		{
			if(strategy==1 || strategy == 2)
			{
			
			repeatLoop = false;
			}
			else
			{
			System.out.println("Insert a valid value for choice of strategy:\n");
			strategy = input.nextInt();
	
			}	
		}//making sure the user inputs the correct value			

		player = new Player(strategy);

		myDeck.shuffle();//shuffling deck

		
		dealer.giveCard(myDeck.draw());//giving the dealer a card
		player.giveCard(myDeck.draw());//giving the player a card
		dealer.giveCard(myDeck.draw());//giving the dealer a card
		player.giveCard(myDeck.draw());//giving the player a card
		

		System.out.println("\nThese are your initial 2 cards:");
		player.allCards();//printing out the player's cards
		
			while(player.takeTurn()==1)
			{
					player.giveCard(myDeck.draw());
					Card[] CardsOfPlayer = player.playerCards();
					
					
					System.out.println("\nThis is your new card: " + CardsOfPlayer[player.numberOfCards()-1]);
											
			}//player hitting or standing

		System.out.println("\nThese are the dealer's intital cards:\n");
		dealer.allCards();//printing out the dealer's cards

		if(player.handValue()<22)
		{
			while(dealer.takeTurn()==1)
			{
				
				dealer.giveCard(myDeck.draw());
				Card[] CardsOfDealer = dealer.playerCards();
				
				System.out.println("\nThe dealer hit and this is his new card: " + CardsOfDealer[dealer.numberOfCards()-1]);	
			}//dealer hitting or standing 
			
		System.out.println("\nThese are your cards after the game has been played: ");
		player.allCards();//printing out the player's cards
		

		
		System.out.println("\nThese are the dealer's cards after the game has been played : ");
		dealer.allCards();//printing out the dealer's cards
		
		System.out.println("\nThe total value of your cards was: " + player.handValue());//printing out the value of all cards the player has

		System.out.println("\nThe total value of the dealer's cards was: " + dealer.handValue());//printing out the value of all cards the dealer has
		
		if((player.handValue()==21)&& dealer.handValue()!=21)
		{
			System.out.println("\nYou won this round!!!");
		}
		else if((player.handValue()== dealer.handValue())&&player.handValue()<22&&dealer.handValue()<22)
		{	
			System.out.println("\nDealer wins.\n\nYou lost this round :(");		
		}
		else if(dealer.handValue()>21 &&player.handValue()<21)
		{
				System.out.println("\nDealer BUSTED\n\nYou won this round!!!");
		}
		else if(player.handValue()>21)
		{
			System.out.println("\nYou BUSTED\n\nYou lost this round :(");
		}
		else if(dealer.handValue()==21&&player.handValue()!=21)
		{
			System.out.println("\nYou lost this round :(");
		}
		else if(dealer.handValue()>player.handValue())
		{
			System.out.println("\nYou lost this round :(");		
		}
		else if(dealer.handValue()<player.handValue())
		{
			System.out.println("\nYou won this round!!!");
		}
	
		}//printing out whether user won or lost depending on user's and dealer's score
		else
		{
			System.out.println("\nThese are your cards after the game has been played: ");
			player.allCards();

		
			System.out.println("\nThese are the dealer's cards after the game has been played : ");
			dealer.allCards();
			
			System.out.println("\nThe total value of your cards was: " + player.handValue());
	
			System.out.println("\nThe total value of the dealer's cards was: " + dealer.handValue());

			System.out.println("\nYou BUSTED\n\nYou lost this round :(");
		
		}//printing out when user busts before dealer get the chance to hit
		
		
		
	}
	
	public static void main(String[] args)
	{
		int repeat = 1;
		while(repeat == 1)
		{
			System.out.println("\nWelcome to BlackJack\n\nTo play press 1 \n\nTo exit press 2 \n");
			Scanner input = new Scanner(System.in);
			
			repeat = input.nextInt();//user input to see whether he wants to play or not
	
			if(repeat == 1)
			{
			BlackJack game = new BlackJack();
			game.playRound();}//playing a game of blackjack if user enters 1
			else if(repeat ==2)
			{System.out.println("\nThank you for playing.");}//message to user for exiting 
			else
			{System.out.println("\nInvalid input\n\nRetry");//in case user is stupid and enters invalid number
			repeat = 1;
			}
			
	
	
		}
	}
	
}

