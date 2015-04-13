/**
* Name: Perabjoth Singh Bajwa
* ID:2449713
* CSCI 2125 Fall 2014
* Homework2 : Singly Linked List
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
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T>implements Iterable<T> {

	private Node head = new Node( null, null);//creating head node
	private Node tail = new Node( null, null);//creating tail node
	
	public SinglyLinkedList(){
		head = new Node(null, tail);//intializing the linked list by pointing the head to the tail
	}

	public void add(T element){
	
		SinglyLinkedListIterator itr = this.iterator();//creating an iterator
		if(head.nextNode==tail)
		{
			Node newNode = new Node(element, tail);//if no elements in list then point it to the tail and point head to it
			head.nextNode = newNode;
		}
		else 
		{
			while(itr.hasNext())//keep iterating while there are more elements
			{
				itr.next();//moving to next element
			}	
			itr.add(element);//adding element at the spot (end of list)
		}
	}

	public void remove(Node prev) throws IllegalStateException
	{
		Node current = head;
		while(current!=prev)//looping until the node is reached
		{
			if(current.nextNode==tail)
			throw new IllegalStateException();//if last node is reached and the result isn't found then exception is thrown
			else
			current=current.nextNode;//move to next node
					
		}
		if(current.nextNode.nextNode==null)//checking if the node after it is null
		throw new IllegalStateException();
		else
		current.nextNode=current.nextNode.nextNode;//removing the node by pointing the current node's next node to the one after it
	}
	public void clear()
	{
		head = new Node(null, tail);//resetting the list
	}
	
	public T getNthToLast(int n)
	{
		Iterator<T> itr = this.iterator();
		Iterator<T> itr2 = this.iterator();
		int size = 0;
		T toBeReturned = null;
		while(itr.hasNext())//using two iterators to get to the nth to last element in N time
		{	
			itr.next();
			size++;	
			if(size>n-1)
			toBeReturned = itr2.next();	
		}
		return toBeReturned;
	}

	public SinglyLinkedListIterator iterator()
	{
		return new SinglyLinkedListIterator();//creating a singlylinkedlistiterator
	}
	
	public class SinglyLinkedListIterator implements Iterator<T>{
		
		private Node current;//keeps track of current node
		
		public SinglyLinkedListIterator(){
		current = head;	//intializes current node as head		
		}
		public boolean hasNext(){
			if(current.nextNode!=null && current.nextNode!=tail)//if the next node isn't the tail or has an element then true
			return true;	
			else 
			return false;
		}
	
		public T next() throws NoSuchElementException
		{
			
			if(current.nextNode==tail)//if there is no next node then an exception is thrown
			{
				throw new NoSuchElementException();
			}
			else{
			    current=current.nextNode;//moving to the next node
			    return current.data;
			}
		}
	
		public void remove()throws IllegalStateException
		{
			Node removable = head;
			if(removable.nextNode==null||removable.nextNode==tail)//checking if the node can be removed
			{
				throw new IllegalStateException();
			}
			while(removable.nextNode!=current)//reaching the node before the current node
			{
				removable=removable.nextNode;		
			}
			removable.nextNode=removable.nextNode.nextNode;//pointing the nextnode of the one before current to the one after it
		}
	
		public void add(T element)
		{
			Node toBeAdded = new Node(element, null);//creating the node
			toBeAdded.nextNode = current.nextNode;//pointing it to the one after the current one
			current.nextNode=toBeAdded;//pointing the current one to it
			
		}
	}
	
	
	public class Node {//simple node class that holds data and points to next node
	
	public Node nextNode;
	public T data;
		public Node( T data, Node nextNode){
		this.nextNode = nextNode;
		this.data=data;
		}	
	}
}
