/**
* Name (ID) : Perabjoth Singh Bajwa (2449713)
*Thursday, November 14, 2013
*1583/1581 fall 2013
*Homework 6: Stacks and Queues (Queues)
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
/**
* Please note that this might not be a conventional Queue
* Suppose that this is the Queue : [A][B][C][D][E][F]
* The way I've designed my code is that [A] is the first element and [F] is the last
* If I add something this is the result : [A][B][C][D][E][F][G]
* If I remmove something this will be the result [B][C][D][E][F][G]
* Peek gives [B]
* and size will give me 6
**/
public class Queue
{
	private String[] array;
	public Queue(int qSize)
	{
		
		array = new String[qSize];//initializing size of Queue using an array	

	}
	public void add(String a)
	{
		int counter = 0;//index of empty element
		
		while(!(this.array[counter] == null))
		{
			counter++;
		}//counting up to the empty index
		String[]temp = new String[this.array.length*2];//temporary array
		for(int i = 0; i < counter; i++)
		{
			temp[i] = this.array[i];

		}//copying the array
		temp[counter] = a;//adding the value to the end of the queue
		this.array = temp;//copying the values of temp back to the original array
		
	}
	public String remove()
	{
		int counter = 0;//index of first element
		String a;
		
		a = this.array[counter];//first element (the one to be removed)
		String[]temp = new String[this.array.length];//temporary array
		for(int i = 0; i <this.array.length ; i++)
		{
			if(i+1<this.array.length)
			{
			temp[i] = this.array[i+1];
			}
			else
			{;}

		}//copying all values except first to the temp array due to use of i+1
		
		this.array = temp;//copying array back to original array
		return a;//returning the value of the first element which has been removed
	}
	public String peek()
	{
		int counter = 0;//index of first element
		String a;
		
		a = this.array[counter];//assigning value to first element
		
		return a;//returning the value 
	}
	public Boolean isEmpty()
	{
		int counter = 0;
		boolean a;
		if(this.array[counter] == null)
		{
			a = true;
		}
		else
		{
		a = false;
		}
		
		
		return a;//obvious and easy
	}
	public int size()
	{
		int counter = 0;//index of empty element
		
		while(!(this.array[counter] == null))
		{
			counter++;
		}//counting up to the empty element
		
		
		return counter ;//returning the value because the value of the index of the empty element is the number of elements in the queue
	}
}
