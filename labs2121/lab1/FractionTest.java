import junit.framework.TestCase;

public class FractionTest extends TestCase{

	private Fraction frac;
	private Fraction frac1;
	private Fraction frac2;
	private Fraction frac3;
	protected void setUp()
	{
	frac= new Fraction(2,3);
	frac1= new Fraction(1,3);
	frac2= new Fraction(3,3);
	frac3= new Fraction(0,3);

	}
	
	public void testConstructor()//testing the constructor to see whether it works with only one parameter
	{
		assertTrue(new Fraction(2,3).equals(frac));
		assertFalse(new Fraction(3,3).equals(frac));
		assertFalse(new Fraction(1).equals(frac2));
	}
	
	public void testAddition()//testing the addition method of the fraction class
	{
		assertTrue(frac.add(frac1).equals( new Fraction(3,3)));
		assertTrue(frac.add(frac3).equals(new Fraction(2,3)));
		assertTrue(frac.add(frac2).equals(new Fraction (5,3)));
	}
	
	public void testSubtraction()//testing the subtraction method of the fraction class
	{
		assertTrue(frac.subtract(frac1).equals(frac1));
		assertTrue(frac3.subtract(frac).equals(new Fraction(-2,3)));
		assertTrue(frac.subtract(frac).equals(new Fraction(frac3)));
	}
	
	public void testMultiplication()//testing the multiplication method of the fraction class 
	{
		assertTrue(frac.multiply(frac).equals(new Fraction(4,9)));
		assertTrue(frac.multiply(frac1).equals(new Fraction(2,9)));
		assertTrue(frac.multiply(frac3).equals(new Fraction(0,9)));
	}
	
	public void testDivision()//testing the division method of the fraction class
	{
		assertTrue(frac.divide(frac1).equals(new Fraction(2,1)));
		assertTrue(frac.divide(frac2).equals(frac));
		assertFalse(frac.divide(frac3).equals(new Fraction(0,3)));
	}
	
	public void testToString()//testing the to string for the fraction class
	{
		assertTrue(frac.toString() == "2/3");
		assertTrue(frac1.toString() == "1/3");
		assertTrue(frac2.toString()== "3/3");
		assertTrue(frac3.toString() == "0/3");
	}
	

}
