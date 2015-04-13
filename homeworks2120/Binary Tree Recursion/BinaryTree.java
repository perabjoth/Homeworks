/**
* Name: Perabjoth Singh Bajwa
* ID:2449713
* CSCI 2120 Spring 2014
* BinaryTree class that uses 
* in order traversal
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
import java.util.ArrayList;

public class BinaryTree
{
// Instance variables
	private int data;
	private BinaryTree leftSubtree;
	private BinaryTree rightSubtree;
	/** Constructor:
	* Parameters: int value contains the data being stored
	* BinaryTree instance variables do not contain sub-trees
	* initially, so they are set to null.
	**/
	public BinaryTree( int value )
	{
		this.data = value;
		this.leftSubtree = null;
		this.rightSubtree = null;
	}
	/**
	* Returns the value stored in this node
	**/
	public int getData()
	{
		return this.data;
	}
	/**
	* Method insert, adds a value to the tree
	* Parameters: int value contains the value to be added
	**/
	public void insert( int value )
	{
		if((Integer)this.data==null)
		{
			this.data = value;//if no value is detected the root is set to be the value
		}
		else if(value<this.data || value == this.data)
		{
			if(this.leftSubtree == null)
			this.leftSubtree = new BinaryTree(value);//if left tree is empty add value there or add it to a subtree of the left tree
			else
			this.leftSubtree.insert(value);
		}
		else if(value>this.data)
		{
			if(this.rightSubtree == null)
			this.rightSubtree = new BinaryTree(value);//if right is empty add value there or add it to a subtree of the right tree
			else
			this.rightSubtree.insert(value);
		}
	}
	/**
	*Method getLeftTree gets the the left tree of the binary tree that is
	*calling it. It is protected for use in JunitTest
	**/
	private BinaryTree getLeftTree()
	{
		return this.leftSubtree;
	}
	/**
	*Method getRightTree gets the the right tree of the binary tree that is
	*calling it. It is protected for use in JunitTest
	**/	
	private BinaryTree getRightTree()
	{
		return this.rightSubtree;
	}
	
	
	/**
	* Method inOrder traverses the tree following the in order
	* traversal algorithm. When each node is ‘visited’ by the
	* algorithm print the value at that node to the screen
	* return type is set as ArrayList<Integer> for use in JuniTest
	**/
	public ArrayList<Integer> inOrder()
	{
		ArrayList<Integer> numbers = new ArrayList<Integer>();//ArrayList holding the numbers in order
		if(this.leftSubtree==null && this.rightSubtree == null)
		{
			numbers.add(numbers.size(), this.data);//saving all data in the ArrayList
		}
		if(this.leftSubtree!=null)
		{
			if(this.leftSubtree.getLeftTree() == null)
			System.out.println(this.leftSubtree.getData());//if the left tree doesn't have a left tree it prints its value
			else if(this.leftSubtree.getLeftTree()!=null)
			this.leftSubtree.inOrder();//otherwise it calls the inOrder method to check for the appropriate value to print
		}
		System.out.println(this.data);
		if(this.rightSubtree!=null)
		{
			if(this.rightSubtree.getLeftTree() == null )
			System.out.println(this.rightSubtree.getData());//if the right tree doesn't have a left tree it prints its value
			else if(this.rightSubtree.getLeftTree()!=null)
			this.rightSubtree.inOrder();//otherwise it calls the inOrder method to check for the appropriate value to print
		}
		for(int i = 0; i<numbers.size();i++)//iterating over elements to print them out
		{
			System.out.println(numbers.get(i));		
		}
		return numbers;
	}
}
