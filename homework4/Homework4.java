/**

 * Perabjoth Singh Bajwa ( ID# : 2449713 )

 * CSCI 1583 Fall 2013

 * Homework 4

 * Wednesday, October 2, 2013

 **/
import java.util.Scanner;
public class Homework4
{
public static void main( String[] args)
	{
	Scanner input = new Scanner(System.in);
	double choice = 0;
	String first = "homework";
	String second = "quiz";
	String third = "test";
	double hwAverage = 0;
	double quizAverage = 0;
	double testAverage = 0;
	double totalAverage;
	while( choice != 2)
		{
			choice = mainMenu();
		
	if(choice == 2)
		{System.out.println("You chose to quit.");
		 break; } //so that the rest of the prompt doesn't show when a person enters 2
	if(choice>2)
		{System.out.println("Error. Option does not exist ");//in case user is stupid and types a wrong number
		break;}
	if(choice<1)
		{System.out.println("Error. Option does not exist ");//in case user is stupid and types a wrong number
		break;}
	System.out.println("Enter the student's name: \n");
	String nameOfStudent;
	nameOfStudent = input.nextLine();
	System.out.println("\nYou are going to enter the student's grades. First, you will enter the homework grades, then the quiz grades and finally test grades.");
	instructions(first);	
	
			hwAverage = average();
		instructions(second);
		quizAverage = average();
		instructions(third);
			testAverage = average();
		totalAverage = finalAverage(hwAverage, quizAverage, testAverage );
		System.out.println("\n\nThe average of " + nameOfStudent + "'s grades is " + totalAverage);
choice = 0; //resetting value so that the program functions
hwAverage = 0; //resetting value so that the program functions
quizAverage = 0; //resetting value so that the program functions
testAverage = 0; //resetting value so that the program functions
		}
	}
public static int mainMenu()
{
Scanner input = new Scanner(System.in);
System.out.println("Choose an option: \n 1)Average grades for a new student\n 2)Quit");
		return input.nextInt(); //scanner for choice
}


public static void instructions(String potato)
	{
		System.out.println("\nNow you will enter the student's " + potato + " grades. When done entering grades press -1.");
	}

public static double average()
{
	double grade = 0; 
	double total = 0;
	double counter = 0;
	double average = 0;
	while(grade != -1)
	{
		System.out.println("\nInsert grade: ");
		Scanner input = new Scanner(System.in);
		grade = input.nextDouble();
		if(grade!=-1)
		{
		total = total + grade;
		counter++;
		}
		if(grade<-1)
		{
			System.out.println("The displayed results will be wrong due to the entry of a negative grade.");
		}
			
		
	}
	
		
	average = total/counter;
	System.out.print("The average of the grades is: " + average);
	return average;

}
public static double finalAverage(double first, double second, double third)
		{
			return (0.25*first) + (0.25*second) + (0.5*third);
					


		}


}
