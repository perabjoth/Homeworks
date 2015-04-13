/**
* Name: Perabjoth Singh Bajwa
* ID:2449713
* CSCI 2125 Fall 2014
* Homework3 : AvlTree HashTable implementation and comparison
* Current File: Testing the runtimes for each data structure
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
import java.util.Random;
public class TestAvlTime{

	public static void main(String[] args)
{

	Random randnum = new Random();
	randnum.setSeed(123456789);//seeding the random number generator so it would produce same values everytime
	int i = 0;
	int n =100;
	while(n<=10000000)//looping while number of elements is less than the value (if value was greater java would run out of heap space)
	{
		System.out.println("For N equals " + n + " elements:");
		AvlTree<Integer> tree = new AvlTree();//creating an avltree made of integers
		System.out.print("Time for insertion of " + n + " elements into AVL tree: ");
		long start_time = System.currentTimeMillis();//recording begin time
		i = 0;//resetting value of i
		while(i<=n)//
		{
			tree.insert(randnum.nextInt());//looping until all elements have been added
			i++;
		}
		long end_time = System.currentTimeMillis();//recording end time
		long total_time = end_time - start_time;//getting runtime
		System.out.println(total_time+ " Milliseconds");
		//tree.printTree();
		System.out.print("Time for insertion of " + n + " elements into SeparateChainingHashTable: " );
		start_time = System.currentTimeMillis();//recording begin time for hashtable
		SeparateChainingHashTable<Integer> table = new SeparateChainingHashTable(n+1);
		i=0;//resetting the value of i
		while(i<=n)
		{
			table.insert(randnum.nextInt());
			i++;	
		}
		end_time = System.currentTimeMillis();//recording end time
		total_time = end_time - start_time;//getting total time
		System.out.println(total_time+ " Milliseconds\n");
	n = n*10;//multiplying to get next set of data which is 10 times larger
	}
}



}
