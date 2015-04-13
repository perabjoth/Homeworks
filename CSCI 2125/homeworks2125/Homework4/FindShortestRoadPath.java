/**
* Name: Perabjoth Singh Bajwa
* ID:2449713
* CSCI 2125 Fall 2014
* Homework4 : Dijkstra's Algorithm
* Current File: main Method
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
import java.io.File;
import java.util.Set;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Hashtable;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.FileOutputStream;

public class FindShortestRoadPath{

public static void main(String [] args) throws FileNotFoundException
	{
		Hashtable<Integer, Vertex> vertices = new Hashtable<Integer,Vertex>();//hashtable containing all values read from file
		Hashtable<Integer, Properties> pathfinder = new Hashtable<Integer, Properties>();//corresponding hashtable to be used for Dijkstra
		ArrayList<Vertex> indices  = new ArrayList<Vertex>();
		File file = new File(args[0]);
		
		try{
			Scanner input = new Scanner(file);
			
			while(input.hasNext()){
				String potato = input.nextLine();
				String[] arr = potato.split(" ");
				if(arr[0].equals("a"))
					{
						
						int index = Integer.parseInt(arr[1]);
						
						Vertex v = new Vertex(index);//creating vertex
						
						Edge edge =  new Edge(Integer.parseInt(arr[2]), Integer.parseInt(arr[3]));//creating corresponding edge
						
						v.addAdjacency(edge);
						if(vertices.get(index) == null){//checking if vertex already exists
						vertices.put(index, v );

						indices.add(v);
						pathfinder.put(index, new Properties());
						}
						else//if it does, then add the edge as an adjacency to exisiting edge
						{
							vertices.get(index).addAdjacency(edge);
						}
					}
			
			}
			input.close();

			//System.out.println(vertices.size() + "= number of vertices");
			int number =0;
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		int source = Integer.parseInt(args[1]);
		int target = Integer.parseInt(args[2]);	
		//System.out.println("number of vertices: "+pathfinder.size());
		//System.out.println(pathfinder.get(1).cost);
		
		Dijkstra finder = new Dijkstra(indices, vertices, pathfinder);
		finder.calculate(source);
		
		//System.out.println(pathfinder.get(2).cost);
			File f = new File(args[3]);
			FileOutputStream out = new FileOutputStream(f);
		//System.out.println("beginning...");
		try{//writing out the results to the output file
			f.createNewFile();
			System.out.println("writing to file...");
			String outputData = "cost from "+source+ " to "+target+ ": "+pathfinder.get(target).cost + "\n";
			out.write(outputData.getBytes());
			outputData = source+ "\n";
			out.write(outputData.getBytes());
			int number = target;
			LinkedList<Integer> path=  new LinkedList<Integer>();
			while(number!=0 && !path.contains(number))
			{
				
				number = pathfinder.get(number).path;
				System.out.println("this is a path: " + number);
				if(number!=source)
				path.add(number);
			}
			for(int i  = 0; i<path.size(); i++)
			{
				if(path.get(i)!=0){
				outputData = path.poll() + "\n";
				out.write(outputData.getBytes());
				}
			}
			Integer integer = target;
			outputData = integer.toString();
			out.write(outputData.getBytes());
			System.out.println("done");
			out.flush();
		}
		catch(Exception e)
		{	
			e.printStackTrace();
		}
		finally{
		try{
		out.close();}
		catch(Exception e)
		{	
			e.printStackTrace();
		}
		}
		

		
	}

	public static class Dijkstra
	{
		public Hashtable<Integer, Properties> pathfinder;
		public Hashtable<Integer, Vertex> vertices;
		public ArrayList<Vertex> indices;
		public Dijkstra(ArrayList<Vertex> indices,Hashtable<Integer, Vertex> vertices, Hashtable<Integer, Properties> pathfinder)//constructor
		{
			this.vertices = vertices;
			this.pathfinder = pathfinder;
			this.indices = indices;
		}

		public void calculate(int source)
		{
		int x =0;
			while(!indices.isEmpty())
			{
				indices.remove(vertices.get(source));
				System.out.println(vertices.get(source));
				LinkedList<Edge> adjacencies = vertices.get(source).getAdjacencies();
				int current = source;
				pathfinder.get(current).known = true;//setting the node being visited to true
				if(x==0){
				pathfinder.get(current).cost=0;//when initial node is selected, set the cost to 0
				pathfinder.get(current).path = 0;}
				Edge[] adj = new Edge[adjacencies.size()];//array containing adjacencies
				for(int i =0; i < adjacencies.size();i++)
				{
					adj[i] = adjacencies.get(i);//copying linked list into array for easier iteration
				}
				
				//System.out.println("calculating for " + source);
				for(Edge e : adj)
				{	
					
					//System.out.println(e.tailNode);
					if(pathfinder.get(e.tailNode).cost>(e.mass+pathfinder.get(current).cost))//if the weight of the path is less than the cost
					{
						pathfinder.get(e.tailNode).cost = pathfinder.get(current).cost + e.mass;//add cost of previous with weight of current
						//System.out.println("running...");
						pathfinder.get(e.tailNode).path = current;//set previous to be the node being visited
					
					}
				
				
				}
				int min=0;//minimum node initialization
				int minCost = 99999999;//initializing mincost to high value to find the real value of it
				Set<Integer> keys = pathfinder.keySet();
				for(Integer any : keys)
				{
					if(pathfinder.get(any).cost<minCost && !pathfinder.get(any).known && indices.contains(vertices.get(any)))//choosing appropriate node to run algorithm next by checking 
													  //if it has least cost and if it hasn't been visited
					{
						minCost = pathfinder.get(any).cost;//need this for the comparison in this loop
				
						min = any;//the index of the minimum node 
					}
				}
			source = min;//calculating the shortest path for the edge with the least cost
			x++;
			}
		}
	
	}
	public static class Properties//properties needed to be added for Dijkstra's algorithm in the corresponding hashtable
		{
			
			boolean known;
			int cost;
			int path;
			public Properties()
			{
				known = false;
				cost = 99999999;
				path = -1;			
			}
		}
		
}
