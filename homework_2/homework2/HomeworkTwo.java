/**
*Perabjoth Singh Bajwa
*CSCI 1583 Fall 2013
*Homework 2
*9/13/2013
**/
import java.util.Scanner;
public class HomeworkTwo
{
    public static void main( String[] args )
	{
		
		
		double firstNumber; // this is the first number that will be inserted by the user
		double secondNumber; // this is the second number that will be inserted by the user
		int choice; // this is the choice that the user will choose for the operation
		double result=0; //this is in order to display the result in the end
		System.out.println( "Enter 1 for addition, 2 for subtraction, 3 for multiplication, 4 for division or 5 to get remainder of division");
		Scanner input = new Scanner( System.in); // scanner for choice 
        	Scanner readerinput = new Scanner( System.in); // scanner for first number
        	Scanner reader = new Scanner( System.in); // scanner for second number
		choice = input.nextInt();
		System.out.println("Insert first number: ");
		firstNumber = readerinput.nextInt();
		System.out.println("Insert second number: ");
		secondNumber = reader.nextInt();
		if(choice>=6)//condition if user enters invalid input
		{
			System.out.println("The result displayed is wrong due to wrong input by user.");
		}		
		if(choice==1)//choice for addition
		{
			result=firstNumber+secondNumber;
		}
		if(choice==2)//choice for subtraction
		{
		result=firstNumber-secondNumber;
		}
		if(choice==3)//choice for multiplication
		{
		result=firstNumber*secondNumber;
		}
		if(choice==4)//choice for division
		{
		result=firstNumber/secondNumber;
		}
		if(choice==5)//choice for remainder aka modulus
		{							
		result=firstNumber%secondNumber;
		}
		System.out.printf( "\nThe result of the opertion you had chosen is: %.2f\n", result );
	}
}

