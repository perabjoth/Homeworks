/**
* Name: Perabjoth Singh Bajwa
* ID:2449713
* CSCI 2125 Fall 2014
* Homework4 : Dijkstra's Algorithm
* Current File: Edge class
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

public class Edge{//simple edge class that holds the index of the tail and the weight of the path to it
		protected int tailNode;
		protected int mass;
		public Edge(int node, int wght)
		{
			tailNode = node;
			mass  = wght;
		}
	}
