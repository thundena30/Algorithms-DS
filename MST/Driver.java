/*Pratyusha Thundena
November 27, 2018
HW MST*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Driver {
   // method that reads input file, prints adjacency list, displays MST information 
	public static void driver(String fileName) throws IOException {
		System.out.println("Input file : " + fileName);
      // Filename constructor 
		File FileName = new File(fileName);
      // FR1 Constructor 
		FileReader FR1 = new FileReader(FileName);
      // BR Constructor 
		BufferedReader BR = new BufferedReader(FR1);
      // graph constructor instantiates WGraph 
		WGraph graph = new WGraph(BR);
		graph.printAdjList();
		long start = System.nanoTime();
		graph.MST();

		long finish = System.nanoTime();

		graph.printMST();
		float total = TimeKeeper(start, finish);

		System.out.println("Total time : " + total);
	}

	public static void main(String[] args) throws IOException {
      String xtralarge = "XtraLargeDG.txt"; 
		String tiny = "tinyDG.txt";
		String medium = "mediumDG.txt";
      String large = "largeDG.txt";
     
		driver(tiny);
		driver(medium);
      driver(large);
      driver(xtralarge); 
     
	}
   // method that returns total time 
	public static float TimeKeeper(long s, long f) {
		//Gives Time in milliseconds
		float Total = (f - s) / 1000000;
		return Total;
	}

}