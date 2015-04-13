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
import java.util.Random;

/**
 * Wrapper class for class Random to make handeling dice rolling easier
 **/
public class Dice
{

    private Random die;

	/**
	*Constructor that initializes that random number generator to make numbers 
	*ranging from 0 to 5
	**/
    public Dice()
    {
		die = new Random();
    }


    /**
     * Returns an integer array of values between 1 and 6 representing the
     * outcome of rolling the dice.  The number of values in the array should be
     * betwen 1 and 3, depending on the number of dice rolled by the player.  The 
     * number of dice rolled by the player is specified by the argument numberOfDice
     **/
    public int[] rollDice( int numberOfDice )
    {
	int[] diceNumber = new int[numberOfDice];	
	for(int i =0; i<numberOfDice; i++)
	{
		diceNumber[i] = die.nextInt(6) + 1;
	}	
	return diceNumber;
    }
	
	public int[] highestNumbers(int[] numbers)
	{
		int[] highestNumbers = new int[2];
		if(numbers.length>1){
		int highest = numbers[0];
		int highest2 =numbers[1];
		for(int i=0; i<numbers.length; i++)
		{
			if(highest<numbers[i])
			{
				highest = numbers[i];
			}
		}
		for(int i=0; i<numbers.length; i++)
		{
			if(highest2<numbers[i] && numbers[i]!=highest)
			{
				highest2 = numbers[i];
			}
		}
		highestNumbers[0]= highest;
		highestNumbers[1]= highest2;
		}else
		{	
		highestNumbers[0] = numbers[0];
		}
		
		return highestNumbers;
		
	}

}
