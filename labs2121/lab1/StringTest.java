/* Name: Perabjoth Singh Bajwa
*ID:2449713
*CSCI: 2121 Spring 2014
*January 27, 2014
**/
import junit.framework.TestCase;
public class StringTest extends TestCase{

	private String letters;
	private String numbers;
	private String empty;
	private String simpleSentence;
	private String complexSentence;

	protected void setUp() {


		letters = new String("abcdefg");
		numbers = new String("1234567890");
		empty = new String("");
		simpleSentence = new String("This is a sentence.\n");
		complexSentence = new String("%Punctuation!, Can cr\te8 <problems.$");
	}
	
	/**
	*testing the String class's length method
	*/
	public void testLength() {

		assertTrue( letters.length() == 7);
		assertTrue( numbers.length() == 10);
		assertTrue( empty.length() == 0);
		assertTrue( simpleSentence.length() == 20);
		assertTrue( complexSentence.length() == 36);
	
	} 

	/**
	*testing the String class's equals method
	*/
	public void testEquals() {
		
		assertTrue(letters.equals("abcdefg"));
		assertTrue(numbers.equals("1234567890"));
		assertTrue(empty.equals(""));
		assertTrue(simpleSentence.equals("This is a sentence.\n"));
		assertTrue(complexSentence.equals("%Punctuation!, Can cr\te8 <problems.$"));
		
	}

	/**
	*testing the String class's toLowerCase method
	*/
	public void testToLowerCase() {
	
		assertTrue(letters.toLowerCase().equals("abcdefg"));
		assertTrue(numbers.toLowerCase().equals("1234567890"));
		assertTrue(empty.toLowerCase().equals(""));
		assertTrue(simpleSentence.toLowerCase().equals("this is a sentence.\n"));
		assertTrue(complexSentence.toLowerCase().equals("%punctuation!, can cr\te8 <problems.$"));
	} 

	


}
