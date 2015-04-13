/**
* Name (ID) : Perabjoth Singh Bajwa (2449713)
*Friday, December 6, 2013
*1583/1581 fall 2013
*Homework 8: BlackJack (Aggressive Strategy class)
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
public class AggressiveStrategy implements Strategy//using the interface strategy
{
	public AggressiveStrategy()
	{
	}
	
	public int hitOrStand(int value)
	{
		
		if(value<20)//hits if value is less than 20
		{return 1;}
		else
		{return 0;}//stand in any other case
	}
}
