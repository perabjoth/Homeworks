/**

 * Perabjoth Singh Bajwa ( ID# : 2449713 )

 * CSCI 1583 Fall 2013

 * Homework 3

 * Wednesday, September 25, 2013

 **/
import java.util.Scanner;
public class Homework3
{
public static void main( String[] args)
	{
	Scanner inputReader = new Scanner(System.in);
	double choice = 0;
	double homeworkGrade = 0;
	double sumOfhwGrades = 0;
	double hwAverage = 0;
	double quizGrade = 0;
	double sumOfQuizGrades = 0;
	double quizAverage = 0;
	double testGrade = 0;
	double sumOfTestGrades = 0;
	double testAverage = 0;
	double counter1 = -1; //to get correct average
	double counter2 = -1; //to get correct average
	double counter3 = -1; //to get correct average
	double totalAverage;
	while( choice != 2)
		{
		System.out.println("Choose an option: \n 1)Average grades for a new student;\n 2)Quit");
		choice = inputReader.nextInt(); //scanner for choice
	if(choice == 2)
		{ break; } //so that the rest of the prompt doesn't show when a person enters 2
	System.out.println("Enter the student's name: \n");
	Scanner input = new Scanner( System.in); //scanner for student's name
	String nameOfStudent;
	nameOfStudent = input.nextLine();
	System.out.println("\nYou are going to enter the student's grades. First, you will enter the homework grades, then the quiz grades and finally test grades.");
	System.out.println("\nNow you will enter the student's homework grades. When done entering grades type -1");	
	Scanner firstGrade = new Scanner( System.in); // scanner for student's grade
		while(homeworkGrade != -1)
			{
			System.out.println("\nInsert grade: ");
			homeworkGrade = firstGrade.nextInt();
			if(homeworkGrade < 0) //in case someone enters a negative value for a grade
			{System.out.println("Error in input. All displayed results will be wrong due to the entry of a negative value.");}
			sumOfhwGrades = sumOfhwGrades + homeworkGrade;
			counter1++;
			}
		hwAverage = (sumOfhwGrades + 1)/counter1;
		System.out.println("The average for the homework grades is " + hwAverage);
		System.out.println("\nNow you will enter the student's quiz grades. When done entering grades -1");	
		Scanner secondGrade = new Scanner( System.in); // scanner for student's grade
		while(quizGrade != -1)
			{
			System.out.println("\nInsert grade: ");
			quizGrade = secondGrade.nextInt();
			if(quizGrade < 0) //in case someone enters a negative value for a grade
			{System.out.println("Error in input. All displayed results will be wrong due to the entry of a negative value.");}
			sumOfQuizGrades+=quizGrade;
			counter2++;
			}
		quizAverage = (sumOfQuizGrades + 1)/counter2;
		System.out.println("The average of the quiz grades is " + quizAverage);
		System.out.println("\nNow you will enter the student's test grades. When done entering grades -1");	
		Scanner thirdGrade = new Scanner( System.in); // scanner for student's grade
		while(testGrade != -1)
			{
			System.out.println("\nInsert grade: ");
			testGrade = thirdGrade.nextInt();
			if(testGrade < 0) //in case someone enters a negative value for a grade
			{System.out.println("Error in input. All displayed results will be wrong due to the entry of a negative value.");}
			sumOfTestGrades+=testGrade;
			counter3++;
			}
		testAverage = (sumOfTestGrades + 1)/counter2;
		System.out.println("The average of the test grades is " + testAverage);
		
		
		totalAverage = (0.25*hwAverage) + (0.25*quizAverage) + (0.5*testAverage);
		System.out.println("\nThe average of " + nameOfStudent + "'s grades is " + totalAverage);
choice = 0; //resetting value so that the program functions
homeworkGrade = 0; //resetting value so that the program functions
sumOfhwGrades = 0; //resetting value so that the program functions
hwAverage = 0; //resetting value so that the program functions
quizGrade = 0; //resetting value so that the program functions
sumOfQuizGrades = 0; //resetting value so that the program functions
quizAverage = 0; //resetting value so that the program functions
testGrade = 0; //resetting value so that the program functions
sumOfTestGrades = 0; //resetting value so that the program functions
testAverage = 0; //resetting value so that the program functions
counter1 = -1; //resetting value so that the program functions
counter2 = -1; //resetting value so that the program functions
counter3 = -1; //resetting value so that the program functions

		}










	}
}
