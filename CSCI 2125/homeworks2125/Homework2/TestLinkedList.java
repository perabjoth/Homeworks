/*
 * JUnit test for HW2
 * Nth to last item in a linked list
 * Aaron Maus
*/ 
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import org.junit.Test; 
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

// @Test flags a method as a test method. 
// @Before indicates that a method will be run before each every
//  test method is run.

public class TestLinkedList{
    private SinglyLinkedList<Integer> list;

    @Rule // this will allow me to test that an exception is thrown
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp(){
        list = new SinglyLinkedList<>();
        SinglyLinkedList<Integer>.SinglyLinkedListIterator it = list.iterator();
        for(int i = 9; i > 0; i--){
            it.add(new Integer(i));
            it.next();
        }
		// Question to all: I could have simplified the process
		// of adding numbers to my list by dispensing
		// with the iterator and simply calling SinglyLinkedList's
		// add() method instead. Why did I use the iterator?
		// What benefit does it provide over SinglyLinkedList's add?
		// (And no, the answer is not to make your lives more
		//  difficult by giving you extra code to implement and
		//  debug.)

		/**Answer: because the iterator will not loop as many times as much
		as the singlylinkedlist's add method
		**/
    }

	// Tests that the linked list holds the expected values
	// after the initialization in the setup() method
	@Test
	public void testIteratorAdd(){
		Iterator<Integer> it = list.iterator();
		Integer listElement;
        for(int i = 9; i > 0; i--){
			listElement = it.next();
        	assertEquals(i, listElement.intValue()); 
        }
	}

    // adds 9-1 to an empty SinglyLinkedList
    // then checks that every element has the
    // expected value
    @Test
    public void testAdd(){
        list.clear();
        for(int i = 9; i > 0; i--){
            list.add(new Integer(i));
        }
		Iterator<Integer> it = list.iterator();
		Integer listElement;
        for(int i = 9; i > 0; i--){
			listElement = it.next();
        	assertEquals(i, listElement.intValue()); 
        }
    }
    
    // creates a list: 9 8 7 6 5 4 3 2 1
    // then deletes all the odd values
    // resulting list:  9 7 5 3 1
    @Test
    public void testDeleteEvenNumbers(){
        // first, remove all the even numbers
        Iterator<Integer> it = list.iterator();
        while(it.hasNext()){
            Integer theVal = it.next().intValue();
            if( theVal.intValue() % 2 == 0){
                it.remove();
            }
        }
        // Next, check that the list contains the correct
        // remaining numbers
        it = list.iterator();
        int oddNum = 9;
        while(it.hasNext()){
            assertEquals(oddNum,it.next().intValue());
            oddNum = oddNum - 2;
        }
    }

    // attempts to remove from an empty list
    // checks to make sure that the IllegalStateException
    // is thrown
    @Test
    public void testEmptyRemove(){
        list.clear();
        thrown.expect(IllegalStateException.class);
        Iterator<Integer> it = list.iterator();
        it.remove();
    }

    // attempts to call next() when already at the
	// end of the list.
    // checks to make sure that the NoSuchElementException
    // is thrown
    @Test
    public void testInvalidNext(){
        list.clear();
        thrown.expect(NoSuchElementException.class);
        Iterator<Integer> it = list.iterator();
        it.next();
	}

	// Test the getNthToLast method. Given the numbers
	// that the list holds, the 4th to last should be 4.
	// For the list: 9 8 7 6 5 4 3 2 1
	// the 2nd to last element is 2
	// the 3rd to last is 3
	// etc...
    @Test
    public void testGetNthToLast(){
        Integer ans = list.getNthToLast(4);
        assertEquals(new Integer(4),ans);
    }
}
