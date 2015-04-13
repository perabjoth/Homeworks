/**
* Name: Perabjoth Singh Bajwa
* ID:2449713
* CSCI 2120 Spring 2014
* BinaryRecursion class that prints
* values in order after reading them from
* a file
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
import java.io.ObjectInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.lang.ClassNotFoundException;

public class BinaryRecursion
{
	//Instance variables
	private ObjectInputStream inputFile;
	private ArrayList<Integer> numbers;
	/**
	*Constructor method that reads the data from the file to build an ArrayList of integers
	**/
	public BinaryRecursion( String fileName)
	{
		try{
			inputFile = new ObjectInputStream(new FileInputStream(fileName));//reading file 
		}
		catch(IOException e)//catching the exception
		{
			e.printStackTrace();
		}
		try{
			numbers = (ArrayList<Integer>)inputFile.readObject();//storing the data as an ArrayList of integers
		}
		catch(ClassNotFoundException e)//catching the exception
		{
			e.printStackTrace();
		}
		catch(IOException e)//catching the exception
		{
			e.printStackTrace();
		}
		try
		{
			inputFile.close();//closing the file after reading 
		}
		catch(IOException e)//catching the exception
		{
			e.printStackTrace();
		}
	}
	/**
	*method getArray returns the ArrayList of integers that was created when the file was read
	**/
	public ArrayList<Integer> getArray()
	{
		return numbers;
	}
	/**
	*main method where the filename is taken as a command line argument
	*it loops over the elements in the array to make the binary tree
	*and then uses the inOrder method from BinaryTree to print the numbers in order
	**/
	public static void main(String[] args)
	{
		BinaryRecursion file = new BinaryRecursion(args[0]);//taking command line argument as parameter of file name
		ArrayList<Integer> unorderedNumbers = file.getArray();//assigning the array that had been read from file to a new Arraylist 
		System.out.println(unorderedNumbers);//printing out the values to see the original order
		BinaryTree tree = new BinaryTree(unorderedNumbers.get(0));//initializing the binary tree with first element of arraylist
		for(int i =1; i<file.getArray().size(); i++)//looping to fill up the binary tree
		{
			tree.insert(unorderedNumbers.get(i));
		}
		tree.inOrder();//printing the numbers in the binary tree in order
	}
}
