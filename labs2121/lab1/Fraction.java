/**
 * Class Fraction
 * Author: Jonathan Redmann, University of New Orleans, Dept of Computer Science
 * Created On: 1/12/14
 * Version: Alpha
 * Description:  Class fraction models a mathematical fraction by preserving the numerator
 * and denominator as seperate values.  It impliments the standard arithmatic operations of
 * addition, subtraction, multiplication, and division.
 **/



// import ArithmeticException class for use in division method
import java.lang.ArithmeticException;



public class Fraction
{

        /**
         *  Instance Variables
         **/
	private int numerator;          // Stores the numerator of the fraction
	private int denominator;        // Stores the denominator of the fraction



        /**
         * Constructor
         * Takes two integer arguments, the numerator and denominator for the fraction
         * being created.
         **/
	public Fraction(int numerator, int denominator)
	{
                // initialize instance variables
		this.numerator = numerator;
		this.denominator = denominator;
	}
        // end constructor



        /**
         * Additon Method
         * Takes one Fraction argument, calculates the sum of the
         * calling Fraction object and its argument, constructs a new Fraction
         * object that stores the sum, and returns this new Fraction object.
         **/
	public Fraction add( Fraction otherFraction )
	{

                // declare and initialize local variables for the numerator and denominator
		int commonDenominator  = this.denominator * otherFraction.denominator;
		int newNumerator = ( this.numerator * otherFraction.denominator ) + ( otherFraction.numerator * this.denominator );

                // Declare and initialize resulting Fraction object using the above numerator and denominator
		Fraction result = new Fraction( newNumerator, commonDenominator );

		return result;

	}
        // end add method



        /**
         * Subtraction  Method
         * Takes one Fraction argument, calculates the difference of the
         * calling Fraction object and its argument, constructs a new Fraction
         * object that stores the difference, and returns this new Fraction object.
         **/
	public Fraction subtract( Fraction otherFraction )
	{

                // declare and initialize local variables for the numerator and denominator
		int commonDenominator = this.denominator * otherFraction.denominator;
		int newNumerator = ( this.numerator * otherFraction.denominator ) - ( otherFraction.numerator * this.denominator );

                // Declare and initialize resulting Fraction object using the above numerator and denominator
		Fraction result = new Fraction( newNumerator, commonDenominator );

		return result;

	}
        // end subtract method



        /**
         * Multiplication Method
         * Takes one Fraction argument, calculates the multiple of the
         * calling Fraction object and its argument, constructs a new Fraction
         * object that stores the multiple, and returns this new Fraction object.
         **/
	public Fraction multiply( Fraction otherFraction )
	{

                // declare and initialize local variables for the numerator and denominator
                int newNumerator = this.numerator * otherFraction.numerator;
                int newDenominator = this.denominator * otherFraction.denominator;

                // Declare and initialize resulting Fraction object using the above numerator and denominator
                Fraction result = new Fraction( newNumerator, newDenominator );

		return result;

	}
        // end multiply method



        /**
         * Division Method
         * Takes one Fraction argument, calculates the dividend of the
         * calling Fraction object and its argument, constructs a new Fraction
         * object that stores the dividend, and returns this new Fraction object.
         **/
	public Fraction divide( Fraction otherFraction ) throws ArithmeticException
	{

                // If the nominator of the divisor is zero throw a division by zero exception
                if( otherFraction.numerator == 0 )
                {

                    throw new ArithmeticException( "Division by Zero" );

                }

                // Construct a new Fraction object that is the inverse of the divisor
		Fraction inverse = new Fraction( otherFraction.denominator, otherFraction.numerator );

                // Calculate the result of the division by multiplying by the inverse of the divisor
                // and store the result in a new Fraction object.
		Fraction result = this.multiply( inverse);

		return result;

	}
        // end divide method



        /**
         * String Conversion Method
         * Uses the state of the object (the numerator and denominator), converts
         * them to strings and the returns a String representation of the Fraction
         * object.
         **/
	public String toString()
	{
		String text = Integer.toString(this.numerator) + "/" + Integer.toString(this.denominator);

		return text;
	}
        // end toString method

}
// END CLASS FRACTION
