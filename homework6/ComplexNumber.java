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
public class ComplexNumber{

	private float real;
	private float imag;
	public ComplexNumber(float x, float y)
	{
		real = x;
		imag = y;
	}


	public float real()
	{
		return real;
	}
	
	public float imag()
	{
		return imag;
	}

	public ComplexNumber add(ComplexNumber second)
	{

		float x;
		float y;
		x = real + second.real;
		y = imag + second.imag;
		ComplexNumber third = new ComplexNumber(x,y);
		return third;
	}

	public ComplexNumber subtract(ComplexNumber second)
	{
		float x;
		float y;
		x = real - second.real;
		y = imag - second.imag;
		ComplexNumber third = new ComplexNumber(x,y);
		return third;
	}
	
	public ComplexNumber multiply(ComplexNumber second)
	{
		float x;
		float y;
		x = real*second.real - imag*second.imag;
		y = imag*second.real + real*second.imag;
		ComplexNumber third = new ComplexNumber(x,y);
		return third;
	}

	public ComplexNumber divide(ComplexNumber second)
	{
		float x;
		float y;
		x = (real*second.real + imag*second.imag)/(second.imag*second.imag + second.real*second.real);
		y = (imag*second.real - real*second.imag)/(second.imag*second.imag + second.real*second.real);
		ComplexNumber third = new ComplexNumber(x,y);
		return third;
	}
	public String toString()
	{
		String print;
		print = real + "+" +  imag + "i";
		return print;
	}
}
