/**
* Name: Perabjoth Singh Bajwa
* ID:2449713
* CSCI 2125 Fall 2014
* Homework4 : Dijkstra's Algorithm
* Current File: Vertex class
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
import java.util.LinkedList;
public class Vertex //simple vertex class that holds its index and adjacencies
	{
		protected int index;
		protected LinkedList<Edge> adjacencies;
	public Vertex(int index)
	{
		this.index = index;
		adjacencies = new LinkedList<Edge>();
	}
	public int getIndex()
	{
		return index;
	}
	public void addAdjacency(Edge edge)
	{
		
		if(!adjacencies.contains(edge))
		{
			adjacencies.add(edge);
		}
	}

	public LinkedList<Edge> getAdjacencies()
	{
		return adjacencies;
	}
}
