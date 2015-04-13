import junit.framework.TestCase;
import java.awt.Rectangle;

public class RectangleTest extends TestCase
{
	Rectangle myRectangle;

	protected void setUp()
	{
		myRectangle = new Rectangle(0,0, 10, 10);	
	}
	
	public void testContains2Parameters()
	{
		assertTrue(myRectangle.contains(5,5));
		assertFalse(myRectangle.contains(15,15));
		//Based on API the following should be correct
		assertTrue(myRectangle.contains(0,0));
		assertFalse(myRectangle.contains(10,10));
		assertFalse(myRectangle.contains(10,5));
		assertTrue(myRectangle.contains(0,5));
		assertTrue(myRectangle.contains(0,1));
		assertTrue(myRectangle.contains(1,0));
	}

}
