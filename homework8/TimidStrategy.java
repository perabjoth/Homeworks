/**
* Name (ID) : Perabjoth Singh Bajwa (2449713)
*Friday, December 6, 2013
*1583/1581 fall 2013
*Homework 8: BlackJack (Timid Strategy class)
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
public class TimidStrategy implements Strategy
{
	public TimidStrategy()
	{
	}
	
	public int hitOrStand(int value)
	{
		if(value<14)//hits if value is less than 14
		{return 1;}
		else
		{return 0;}//stands in all other cases
	
	
	}
}
