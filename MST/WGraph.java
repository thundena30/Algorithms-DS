/*Pratyusha Thundena
November 27, 2018
HW MST*/

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class WGraph {
    private int V;
    private int E;
    private double adj[][];
    private int parent[];
    
    
    // method that reads weighted graph info
    WGraph(BufferedReader reader) throws IOException {
        String line;
        // reader constructor that reads string line in input file 
        line = reader.readLine();
        V = Integer.parseInt(line);
        line = reader.readLine();
        E = Integer.parseInt(line);
        adj = new double[V][];
				parent = new int[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new double[V];
            for (int j = 0; j < V; ++j) {
                adj[i][j] = -1;
            }
        }

        while ((line = reader.readLine()) != null) {
            // st constructor makes sure that the string is read properly 
            StringTokenizer st = new StringTokenizer(line, " ");
            // Integer constructor that reads numbers in text files
            int tempV1 = Integer.parseInt(st.nextToken());
            int tempV2 = Integer.parseInt(st.nextToken());
            // Double constructor that reads numbers in text files 
            double tempW1 = Double.parseDouble(st.nextToken());
            adj[tempV1][tempV2] = tempW1;
        }

    }
   // method that prints out adjacency list 
    public void printAdjList() {
        System.out.println("Adjacency List");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                System.out.print(adj[i][j] + "\t");
            }
            System.out.println();
        }
    }


    class node {
        int vertex;
        double key;
    }
   // method that finds MST 
    public void MST() {
        Boolean[] mstset = new Boolean[V];
        node[] e = new node[V];

        for (int o = 0; o < V; o++)
            e[o] = new node();

        for (int o = 0; o < V; o++) {

            mstset[o] = false;
            
            // Constructor that instantiates new nodes 
            e[o].key = Double.MAX_VALUE;
            e[o].vertex = o;
            parent[o] = -1;
        }

        mstset[0] = true;
        e[0].key = 0;

        PriorityQueue<node> queue = new PriorityQueue<>(V, (n0, n1) -> {
            Double diff = n0.key - n1.key;
            if (diff > 0) {
                return 1;
            } else if (diff < 0) {
                return -1;
            } else {
                return 0;
            }
        });

        for (int o = 0; o < V; o++)
            queue.add(e[o]);
         // constructor that instantiates queue elements 
        while (!queue.isEmpty()) {
            node node0 = queue.poll();
            mstset[node0.vertex] = true;
            for (int i = 0; i < V; ++i) {
                Integer dest = i;
                Double weight = adj[node0.vertex][dest];
                if (!mstset[dest] && weight != -1) {
                    if (e[dest].key > weight) {
                        queue.remove(dest);
                        e[dest].key = weight;
                        queue.add(e[dest]);
                        parent[dest] = node0.vertex;
                    }
                }
            }
        }
    }
     
     //method that prints MST 

		public void printMST() {
				System.out.println("Edges in MST : ");

        for (int o = 1; o < V; o++)
            System.out.println(parent[o] + " - " + o);
		}
}