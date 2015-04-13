/**
* Name (ID) : Perabjoth Singh Bajwa (2449713)
*Thursday, November 14, 2013
*1583/1581 fall 2013
*Homework 6: Stacks and Queues (Stacks)
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
/** Please note that my code hasn't been made in the conventional method.
* DO NOT EVALUATE BEFORE READING THE FOLLOWING:
* Suppose the following is a stack [A][B][C][D][E][F].
* The way I've designed my code is that [A] is the bottom of the pile and [F]
* is the top of the pile where the index of [A] is 0 and the index of [F] is 5.
* So when I push something on this stack this will be the result:
* [A][B][C][D][E][F][G]
* and if I pop something this will be the result:
* [A][B][C][D][E][F]
* and if I peek I will get [F] and the size would be 6
* If my grade is not a 100 and you want me to rewrite the code in the way you think, just tell me and
* I will do it.
**/
public class Stack
{
	private String[] array;
	
	public Stack(int stackSize)
	{
		this.array = new String[stackSize];//initializing stack size using the array
	}

	public void push(String a)
	{
		int counter = 0;//index of the element that is empty in the stack where String a will be inserted
		
		while(!(this.array[counter] == null))
		{
			counter++;
		}//counting up to find the empty element
		String[]temp = new String[this.array.length*2];
		for(int i = 0; i < counter; i++)
		{
			temp[i] = this.array[i];

		}//copying array
		temp[counter] = a;//adding the element in the empty space
		this.array = temp;//the new array containing the added element is assigned back to the original one
		
	}
	public String pop()
	{
		int counter = 0;//keeping record of the index of the empty element in the stack
		String a;//the value to be returned
		while(!(this.array[counter] == null))
		{
			counter++;
		}
		if(counter>0)
		{
			a = this.array[counter - 1];//the element that is on top of the stack 
			String[]temp = new String[this.array.length];//temporary array 
			for(int i = 0; i < counter - 1 ; i++)
			{
				temp[i] = this.array[i];//copying all elements except the one on top due to counter-1 in the condition of for statement
	
			}
			
			this.array = temp;
			return a;	
		}
		else
		{
			a = null; 
			return a;
		}
	}
	public String peek()
	{
		int counter = 0;//index of empty element
		String a;
		while(!(this.array[counter] == null))
		{
			counter++;
		}//counting to the empty element
		a = this.array[counter - 1];//assigning a the value of the element on top
		
		return a;
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
		
		
		return counter;//returning the value because the value of the index of the empty element is the number of elements in the stack
	}
}
