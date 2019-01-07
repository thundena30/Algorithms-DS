/*Pratyusha Thundena
November 10, 2018
HW 11*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


public class DepthFirstPaths {

	//all the variables for Depth First.
	private static int[] pi;
	private static int[] d;
	private static int[] f;
	private static int[] color;
	private static int time;
	private static int nil = -1; // nil
	private static int WHITE = 0;
	private static int GRAY = 1;
	private static int BLACK = 2;
	
	// used for time.
	private static long LStartTime = 0;
	private static long LEndTime = 0;
	

	public static void main(String[] args) throws IOException {
		/** Driver to test and compare the times etc. */
		String tinyDG = "tinyDG.txt";
		String mediumG = "mediumG.txt";
		// Setup for the mediumG file.
		FileInputStream undirectedFile = new FileInputStream(mediumG);
		BufferedReader undirectedBuffer = new BufferedReader(new InputStreamReader(undirectedFile));
		UndirectedGraph undirected = new UndirectedGraph(undirectedBuffer);
		undirectedBuffer.close();
		undirectedFile.close();
		// Setup for the tinyDG file.
		FileInputStream directedFile = new FileInputStream(tinyDG);
		BufferedReader directedBuffer = new BufferedReader(new InputStreamReader(directedFile));
		DirectedGraph directed = new DirectedGraph(directedBuffer);
		directedBuffer.close();
		undirectedFile.close();

		// Run the DFS
		runDFS(undirected);
 		// list graph DFS with topological sort
		long tStartTime = System.nanoTime();
		// this produces the sortedGraph
		LinkedList<Integer> sortedGraph = topSort(directed);
		long tEndTime = System.nanoTime();
		System.out.println("Topological sort:");
		// Loop through and print it.
		for (int u : sortedGraph)
			System.out.println("Item " + u + ": " + d[u] + "/" + f[u]);
		
		System.out.println("\nDepth First Path (nanoseconds): " + (LEndTime-LStartTime));
		System.out.println("Topological sort(nanoseconds): " + (tEndTime-tStartTime));
	}

	public static void runDFS(Graph G)
	{
		int s = 0;
		// start the timer.
		LStartTime = System.nanoTime();
		// Start the DepthsFirst Algorithm 
		DFS(G, s); 
		// End the timer.
		LEndTime = System.nanoTime();

		for (int v = 0; v<G.V; v++)
		{
			System.out.print(s + " to " + v + ": ");
			printDFS(G, s, v);
			System.out.println("\n");
		}
	}

	public static void DFS(Graph G, int s)
	{
		
		int size = G.V;
		color = new int[size];
		d = new int[size];
		f = new int[size];
		pi = new int[size];
		// Loop through and set the color to white
		// and pi to nil on all of them.
		for (int u = 0; u<G.V; u++)
		{
			color[u] = WHITE;
			pi[u] = nil;
		}
		// time is 0 
		time = 0; 
		// if its a WHITE call the visit.
		for (int u = 0; u<G.V; u++)
			if (color[u] == WHITE)
				visitDFS(G, u);
	}
	
	public static void visitDFS(Graph G, int u)
	{
		// add timme.
		time++; 
		// set d[u] to the time value to an int
		d[u] = time;
		// color is now set to gray.
		color[u] = GRAY;
		// loop through G.adj[u] 
		for (int v : G.adj[u]) 
		// if the color is white, set the pi[v] = u and then visit DFS again.

			if (color[v] == WHITE) {
				pi[v] = u;
				visitDFS(G, v);
			}
			//Finished
		color[u] = BLACK; 
		// add the time, set f[u] to time.
		time++;
		f[u] = time;
	}

	public static void printDFS(Graph G, int s, int v)
	{
		if (v == s)
			System.out.print(s);
		else if (pi[v] == nil)
			System.out.print("No path");
		else {
			printDFS(G, s, pi[v]);
			System.out.print("," + v);
		}
	}
	
	public static LinkedList<Integer> topSort(DirectedGraph G) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		for (int v = 0; v<G.V; v++)
		{
			DFS(G, v);
			result.addFirst(v);;
		}
		return result;
	}
}
