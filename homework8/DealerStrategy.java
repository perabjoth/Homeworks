/**
* Name (ID) : Perabjoth Singh Bajwa (2449713)
*Friday, December 6, 2013
*1583/1581 fall 2013
*Homework 8: BlackJack (Dealer Strategy class)
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
public class DealerStrategy implements Strategy
{
	
	
	public DealerStrategy()
	{ 
		
		

	}
	
	public int hitOrStand(int value)
	{
	
		if(value<17)//hits if value is less than 17
		{return 1;}
		else
		{return 0;}//stands in all other cases
	
	}
}
