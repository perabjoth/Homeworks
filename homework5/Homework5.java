/**
* Name (ID) : Perabjoth Singh Bajwa (2449713)
*Friday October 25, 2013
*1583/1581 fall 2013
*Homework 5: Conway's Game of Life
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
import java.io.File;
import java.util.Scanner;
public class Homework5
{
public static void main( String[] args) throws Exception
	{
		File newFile = new File(args[0]);//to take a file as an argument
		Scanner input = new Scanner(newFile);//to read data from the file
		Scanner inputFromUser = new Scanner(System.in);	//to take inout from user to see if he wants to see next generation	
		int row;//number of rows in array
		int column;//number of columns in array
		int total;//sum of integers surrounding a single element 
		int userCondition = 1;//condition to continue loop 
		int[][] array1;//to make a copy of initial array
		int[][] array = new int[0][0];//initializing array
		while(input.hasNext())//inserting the data from the file to the array
		{
			column = input.nextInt();
			row = input.nextInt(); 
			array = new int[row][column];
			for(int counter =0 ; counter < array.length; counter++)
			{
				for(int counter2 = 0 ; counter2<array[counter].length ; counter2++)
				{
					array[counter][counter2] = input.nextInt();			
						
				}
			}
		
	
		}
		
		input.close();
		while(userCondition==1)//check to see if condition true or false to loop
		{
			
			array1 = copy(array);
			for(int a =0; a<array1.length; a++)
			{
				for(int b = 0; b<array1[a].length; b++)
				{
					System.out.print(array1[a][b] + " ");	
				}
	
			System.out.println();
			
	
			}
			System.out.println("\nPress 1 to see next generation or press 2 to quit:\n");
			userCondition = inputFromUser.nextInt();
			
			if(userCondition==1)// also to check condition in order to execute
			{
				for(int counter =0; counter<array.length ; counter++)
				{
					for(int x =0; x<array[counter].length; x++)//all possible situations to be checked 
					{
						if(counter==0 && x==0)
						{total= array1[counter+1][x]+array1[counter][x+1]+array1[counter+1][x+1];}
						else if(counter==0 && x>0 && x!= (array[counter].length-1))
						{total = array1[counter][x-1]+array1[counter+1][x+1]+array1[counter+1][x]+array1[counter+1][x-1]+array1[counter][x+1];}
						else if(counter>0 && counter != (array.length-1) && x==0)
						{total = array1[counter-1][x] + array1[counter+1][x]+ array1[counter-1][x+1] + array1[counter][x+1] + array1[counter+1][x+1];}
						else if(counter == (array.length-1) && x ==0)
						{total = array1[counter-1][x] + array1[counter-1][x+1] + array1[counter][x+1];}
						else if(counter == 0 && x == (array[counter].length-1))
						{total = array1[counter+1][x]+array1[counter][x-1]+array1[counter+1][x-1];}
						else if(counter == (array.length-1) && x == (array[counter].length-1))
						{total = array1[counter-1][x] + array1[counter][x-1] + array1[counter-1][x-1];}
						else if(counter>0 && counter<(array.length-1) && x ==(array[counter].length-1))
						{total= array1[counter-1][x]+array1[counter-1][x-1]+array1[counter][x-1]+array1[counter+1][x-1]+array1[counter+1][x];}
						else if(counter==(array.length-1) && x>0 && x<(array[counter].length-1))
						{total = array1[counter][x-1]+array1[counter-1][x-1]+array1[counter-1][x]+array1[counter-1][x+1]+array1[counter][x+1];}
						else
						{total= array1[counter+1][x] + array1[counter][x+1] + array1[counter+1][x+1]  + array1[counter+1][x-1] + array1[counter-1][x+1] + array1[counter-1][x] + array1[counter][x-1] + array1[counter-1][x-1];}
						
						if(total<2)//to see whether the element will be modified or not
						{array[counter][x] = 0;
						}
						else if(total==2)
						{array[counter][x]= array[counter][x];
						}
						else if(total==3)
						{array[counter][x]=1;
						}
						else 
						{array[counter][x]= 0;
						}
						
						
		
					}
						
						
			
					System.out.println();
		
				}
			}
		}	
}

public static int[][] copy(int[][]someArray)//method to copy array to array1
{   
	int[][] array2 = new int[someArray.length][someArray[0].length];//initializing the array
	for(int counter =0 ; counter< someArray.length; counter++)
	{
		for(int counter2 = 0; counter2<someArray[counter].length; counter2++)//giving the second array the values of the original one
		{
		
		array2[counter][counter2] = someArray[counter][counter2];


		}


	}

return  array2;

}
}
