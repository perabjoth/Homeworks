/**
* Name: Perabjoth Singh Bajwa
* ID:2449713
* CSCI 2120 Spring 2014
* Junit test for the BinaryTree class
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
import junit.framework.TestCase;
import java.util.ArrayList;

public class JunitTest extends TestCase
{
	//instance variable
	private BinaryTree tree;
	/**
	*method to initialize variables
	**/
	protected void setUp()
	{
		tree = new BinaryTree(10);//initializig the binary tree with a value of 10
	}
	/**
	*method to test the getData method
	**/
	public void testGetData()
	{
		assertTrue(10==tree.getData());//testing the getData method by checking that the binary tree's main element is 10
	}
	/**
	*method to test insert method
	**/
	public void testInsert()
	{
		tree.insert(5);//inserting 5 to the left of the tree
		tree.insert(12);//inserting 12 to the right of the tree
		ArrayList<Integer> numbers = new ArrayList<Integer>();//new ArrayList that holds same values of tree in order
		numbers.add(0, 5);//adding numbers in order to the ArrayList
		numbers.add(1,10);
		numbers.add(2,12);
		assertTrue(numbers.containsAll(tree.inOrder()));//testing if it inserted the value in the right way
	}
	/**
	*method to test inOrder method
	**/
	public void testInOrder()
	{
		tree.insert(5);//inserting 5
		tree.insert(12);//inserting 11
		ArrayList<Integer> numbers = new ArrayList<Integer>();//new ArrayList holding the values of the tree in order
		numbers.add(0,5);//adding the values in order
		numbers.add(1,10);
		numbers.add(2,12);
		assertTrue(numbers.containsAll(tree.inOrder()));//testing if it generated an ArrayList holding values in order
		
	
	}
 }
