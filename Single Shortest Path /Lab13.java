/*Pratyusha Thundena
Dec 4, 2018
Lab 13*/


// import the following libraries:
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lab13 {
   // driver program 
	public static void main(String[] args) throws FileNotFoundException, IOException {
		WeightedGraph graph = new WeightedGraph(new BufferedReader(new FileReader("tinyDG.txt")));
		long dijkstraStart = System.nanoTime();
		graph.Djikstra(0);
		
      // get time in nanoseconds 
		long dijkstraEnd = System.nanoTime();
		
		System.out.println("Total time elapsed for Tiny graph : " + (dijkstraEnd - dijkstraStart) + " nanoSeconds");
		System.out.println(graph.printPath(0,graph.getVertexCount()-1));
		
      // read text file and open WeightedGraph for mediumDG.txt 
		graph = new WeightedGraph(new BufferedReader(new FileReader("mediumDG.txt")));
		dijkstraStart = System.nanoTime();
      // constructor 
		graph.Djikstra(0);
		
		dijkstraEnd = System.nanoTime();
		System.out.println("\nTotal time elapsed for Medium graph : " + (dijkstraEnd - dijkstraStart) + " nanoSeconds");
		System.out.println(graph.printPath(0,graph.getVertexCount()-1));
		
		graph = new WeightedGraph(new BufferedReader(new FileReader("largeDG.txt")));
		dijkstraStart = System.nanoTime();
		graph.Djikstra(0);
		
		dijkstraEnd = System.nanoTime();
		System.out.println("\nTotal time elapsed for Large graph : " + (dijkstraEnd - dijkstraStart) + " nanoSeconds");
		System.out.println(graph.printPath(0,graph.getVertexCount()-1));

		graph = new WeightedGraph(new BufferedReader(new FileReader("XtraLargeDG.txt")));
		dijkstraStart = System.nanoTime();
		graph.Djikstra(0);
		
		dijkstraEnd = System.nanoTime();
		System.out.println("\nTotal time elapsed for XtraLarge graph : " + (dijkstraEnd - dijkstraStart) + " nanoSeconds");
		System.out.println(graph.printPath(0,graph.getVertexCount()-1));

	}
	
	

}