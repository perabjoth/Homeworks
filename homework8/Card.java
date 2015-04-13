/**
* Name (ID) : Perabjoth Singh Bajwa (2449713)
*Friday, December 6, 2013
*1583/1581 fall 2013
*Homework 8: BlackJack (Card class)
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
public class Card
{
	
	private String suit;//the suit name
	private int value;//the value of the card
	private String name;//name of the card 
	private int number;//the index of the card

	public Card(int x )
		{
			number = x;
			name = null;
			suit = null;
			value = 0;
			
		}
	public String suit()
		{
			
			
				if(number/13 == 0 || number ==13)
				{suit = "Clubs";}//Cards 1 to 13 are clubs
				else if((number/13 == 1 && number!=13) || number ==26)
				{suit = "Diamonds";}//Cards 14 to 26 are diamonds
				else if((number/13 == 2 && number!=26)|| number ==39)
				{suit = "Hearts";}//Cards 27 to 39 are hearts
				else if(number/13 == 3 && number!=39 || number ==52)
				{suit = "Spades";}//Cards 40 to 52 are spades
								
			
		return suit;
		}
	public int value()
		{
			Player p1 = new Player(1);
			Player p2 = new Player(2);
			Player p3 = new Player(3);//three players with different strategies
				
				if((number%13)==1)//giving the value to the Ace
				{
					if(p1.handValue()<11)
					{value=11;}//if the sum of the player's cards is less than 11 then ace has a value of 11
					else
					{value=1;}//if the sum of the player's cards is greater than 11 then ace has a value of 1
					
					if(p2.handValue()<11)
					{value=11;}//if the sum of the player's cards is less than 11 then ace has a value of 11
					else
					{value=1;}//if the sum of the player's cards is greater than 11 then ace has a value of 1
			
					if(p3.handValue()<11)
					{value=11;}//if the sum of the player's cards is less than 11 then ace has a value of 11
					else
					{value=1;}//if the sum of the player's cards is greater than 11 then ace has a value of 1
				}
				else if((number%13) ==2)
				{value =2;}
				else if((number%13)==3)
				{value =3;}
				else if((number%13)==4)
				{value =4;}
				else if((number%13) ==5)
				{value =5;}
				else if((number%13) ==6)
				{value =6;}
				else if((number%13)==7)
				{value = 7;}
				else if((number%13)==8)
				{value =8;}
				else if((number%13)==9)
				{value =9;}
				else if((number%13) ==10)
				{value =10;}
				else if((number%13)==11)
				{value = 10;}
				else if((number%13)==12)
				{value = 10;}
				else if((number%13)==0)
				{value = 10;}
				//assigned the values to the respective cards
					
				
					
				
					
		
		return value;
		
		}
	public String name()
	{
						
				if((number%13)==1)
				{name = "Ace";}
				else if((number%13) ==2)
				{name ="2";}
				else if((number%13)==3)
				{name ="3";}
				else if((number%13)==4)
				{name ="4";}
				else if((number%13) ==5)
				{name ="5";}
				else if((number%13) ==6)
				{name ="6";}
				else if((number%13)==7)
				{name = "7";}
				else if((number%13)==8)
				{name ="8";}
				else if((number%13)==9)
				{name ="9";}
				else if((number%13) ==10)
				{name ="10";}
				else if((number%13)==11)
				{name = "Jack";}
				else if((number%13)==12)
				{name = "Queen";}
				else if((number%13)==0)
				{name = "King";}
				//assigning the names to their respective cards
		return name;	
	}
	@Override
	public String toString()
		{
			
			
			String theCard;	
			theCard = name() + " of " + suit();//the whole name of the card 
			return theCard;		
		
		}


}
