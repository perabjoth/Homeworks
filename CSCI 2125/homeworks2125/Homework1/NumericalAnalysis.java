/**
* Name: Perabjoth Singh Bajwa
* ID:2449713
* CSCI 2125 Fall 2014
* Homework1 : Root finder
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
public class NumericalAnalysis{

	public NumericalAnalysis()
	{
	}
	
	public double solveForZero(SomeFunction fun, double low, double high)
	{
		double lowYValue = fun.f(low);//gets the y value associated with the low x
		double highYValue = fun.f(high);//gets the x value associated with the high x
		double difference = high - low;//calculates the difference of high and low
		difference = difference/1000;
		double[] input = new double[1000]; 
		for(int i = 0; i<1000 ; i++)
			{
				input[i]=(low + (difference*i));//creates an array of a 1000 values between low and high
			}
		double[] numbers = new double[1000]; 
		for(int i = 0; i<1000 ; i++)
			{
				numbers[i]=fun.f(input[i]);//creates an array of a 1000 y values corresponding to the values of low and high
			}
		int left = 0;
		int right = numbers.length-1;
		int middle = (right+left)/2;
		boolean notFound = true;
		while(notFound)//infinite loop that breaks when answer is found
			{
				middle = (right+left)/2;//find the middle index to search within the y values
				if(numbers[middle]==0 || (numbers[middle]<0.01 && numbers[middle]>-0.01))//if y is within the error range of 0.01 it returns the answer	
				{
					
					return input[middle];
				}
				if(numbers[left]==0 || (numbers[left]<0.01 && numbers[left]>-0.01))//if y is within the error range of 0.01 it returns the answer
				{
					
					return input[left];
				}
				
				if(numbers[right]==0 || (numbers[right]<0.01 && numbers[right]>-0.01))//if y is within the error range of 0.01 it returns the answer
				{
					
					return input[right];
				}
				if(numbers[middle]>0)//if y is closer to the 0 from the left, then move the right to the left by replacing it with the middle
				{
					right = middle;
				}
				
				if(numbers[middle]<0)//if y is closer to the 0 from the right, then move the left to the right by replacing it with the middle
				{
					left=middle;
				}
			}
	return 0.01010101010101;//program was demanding a return statement
	}
}
