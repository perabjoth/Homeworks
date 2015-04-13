/**
* Name (ID) : Perabjoth Singh Bajwa (2449713)
*Tuesday November 5, 2013
*1583/1581 fall 2013
*Homework 6: Complex Numbers
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
import java.util.Scanner;
public class ComplexTester{

	public static void main(String[] args){
	
	int x = 1;
	float real;
	float imag;
	float real1;
	float imag1;
	ComplexNumber result;
	while( x>0 && x<6)
	{	
		System.out.println("\nInsert value for real part of first complex number: \n");
		Scanner input = new Scanner(System.in);
		real = input.nextFloat();
		System.out.println("\nInsert value for imaginary part of first complex number: \n");
		imag = input.nextFloat();
		System.out.println("\nInsert value for real part of second complex number: \n");
		real1 = input.nextFloat();
		System.out.println("\nInsert value for imaginary part of second complex number: \n");
		imag1 = input.nextFloat();
		ComplexNumber first = new ComplexNumber(real, imag);
		ComplexNumber second = new ComplexNumber(real1,imag1);
		System.out.println("\nInsert 1 for addition, 2 for subtraction, 3 for multiplication, 4 for division or 5 to quit: \n");
		x = input.nextInt();
		if(x==1)
		{result = first.add(second);
		System.out.println("\nFirst Complex Number + Second Complex Number = " + result);
		}
		else if(x==2)
		{result = first.subtract(second);
		System.out.println("\nFirst Complex Number - Second Complex Number = " + result);}
		else if(x==3)
		{result = first.multiply(second);
		System.out.println("\nFirst Complex Number x Second Complex Number = " + result);}
		else if(x==4)
		{result = first.divide(second);
		System.out.println("\nFirst Complex Number / Second Complex Number = " + result);}
		else if(x==5)
		{System.out.println("\nYou chose to quit\n");}
		else 
		{System.out.println("\n<<Invalid input>> Program will terminate\n");}

		}
	}
}
