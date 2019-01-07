/*Pratyusha Thundena
November 4, 2018
Lab 10 - BFS */



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// the graph class structure
class Graph
{
	// the number of nodes
	private int V;
	
	// the list of nodes of list
	private ArrayList< LinkedList<Integer> > nodesList;
	
	// the constructor
	public Graph(int V)
	{
		// the number of nodes
		this.V = V;
		
		// create a list of nodes
		nodesList = new ArrayList<>();
		
		// add V numbers of empty lists to it
		for( int i=0; i<V; i++)
			nodesList.add( new LinkedList<Integer>());
	}
	
	// get the number of nodes
	public int getNumNodes()
	{
		return V;
	}
	
	// to add neighbors
	public void addNeighbors(int a, int b)
	{
		// add a as neighbor of b, add b as neighbor of a
		nodesList.get(b).add(a);
		nodesList.get(a).add(b);
	}
	// the list of adjacent nodes
	public LinkedList<Integer> getNeigbors(int n)
	{
		return nodesList.get(n);
	}
	
	// print the graph
	public void print()
	{
		// the list of nodes
		for( int i=0; i<V; i++ )
		{
			// print this node
			System.out.print(i + ":");
			
			// print this list
			for( int j=0; j<nodesList.get(i).size(); j++)
			{
				// if this is the last node
				if( j == nodesList.get(i).size() - 1)
				{
					// print this and change line
					System.out.println( nodesList.get(i).get(j));
				}
				else
				{
					// print with a comma
					System.out.print( nodesList.get(i).get(j) + ",");
				}
			}
		}
	}
}
public class Lab10 
{	
	// the graph
	private static Graph graph;
	
	// method to read the file
	private static void readFile(String fileName) throws FileNotFoundException
	{
		// the scanner to read the file
		Scanner scanner = new Scanner(new File(fileName));
		
		// read lines by lines
		
		// read the number of nodes
		int numNodes = scanner.nextInt();
		// create graph
		graph = new Graph(numNodes);
		
		// create the 
		int numEdges = scanner.nextInt();
		
		// add the neighbors
		
		for( int i=0; i<numEdges; i++)
		{
			// get the nodes
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			// add neighbors
			graph.addNeighbors(a, b);
		}
		
		// close the scanner
		scanner.close();
	}
	
	// the bfs
	private static void BFS()
	{
		// the distance to array
		int[] distanceTo = new int[ graph.getNumNodes() ];
		int[] pi = new int[ graph.getNumNodes() ];
		
		// the found
		boolean[] found = new boolean[ graph.getNumNodes() ];
		
		// set white and gray
		boolean white = true;
		boolean gray = false;
		
		// do bfs
		for( int i=0; i<graph.getNumNodes(); i++)
		{
			distanceTo[i] = Integer.MAX_VALUE;
			pi[i] = -1;
			found[i] = white;
		}
		
		// 0 is the source 
		int source = 0;
		
		// set the source parameters
		distanceTo[ source ] = 0;
		pi[ source ] = -1;
		found[ source ] = gray;
		
		// the queue
		Queue<Integer> queue = new LinkedList<>();
		
		// add source
		queue.add(source);
		
		// as long as queue is not empty
		while( !queue.isEmpty() )
		{
			// dequeue
			int u = queue.poll();
			
			// for each list in the adjacent
			for( Integer v : graph.getNeigbors(u))
			{
				// if this is white
				if( found[v] == white )
				{
					found[v] = gray;
					distanceTo[v] = distanceTo[u] + 1;
					pi[v] = u;
					queue.add(v);
				}
			}
			
			// color of u is black
			found[u] = gray;
		}
		
		// print paths from source
		System.out.println();
		System.out.println("Paths from source 0 to nodes are : ");
		
		
		// print the path
		for( int i=1; i<graph.getNumNodes(); i++)
		{
			printPath(source, i, pi);
			System.out.println();
		}
	}
	
	// print path
	private static void printPath(int s,int v, int pi[])
	{
		if( v == s )
			System.out.print(s);
		else if( pi[v] == -1 )
			System.out.println("No path from " + s + " to " + v + " exists.");
		else 
		{
			printPath(s, pi[v], pi);
			System.out.print("->" + v);
		}
		
	}
	
	// the main method
	public static void main(String args[]) throws FileNotFoundException
	{
		// scanner to read input
		Scanner scanner = new Scanner(System.in);
		
		// ask for the file name
		System.out.print("Enter the name of the input file : ");
		
		String inputFile = scanner.next();
		
		// read the graph
		readFile(inputFile);
		
		// print the graph
		System.out.println("The graph : ");
		graph.print();
		
		// Perform the bfs
		BFS();
		
		// close the scanner
		scanner.close();
	}
}
