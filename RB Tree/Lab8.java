/*Pratyusha Thundena
October 23, 2018
Lab 8 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Lab8 {

    public static void main(String[] args) {
        /**
        * This is just to a test that the method was working before adding in the files method. to make sure everything is working...
         * Its not needed for the actually app
         */
        /*
         * RBTree rtree = new RBTree(); Random rand = new Random();
         * 
         * System.out.println("Random list of Numbers "); for (int i = 0; i < 100; i++)
         * { int n = rand.nextInt(10); System.out.print(n + " "); RBNode current = new
         * RBNode((long) n, "test"); rtree.RBInsert(current); }
         * System.out.println("\n\nSorted numbers using the RBT: ");
         * rtree.inOrderTreeWalk(rtree.root);
         */

        try {
            RBTree tree = new RBTree();
            Scanner input;
            input = new Scanner(new File("UPC-random.csv"));
            long totalRunTime = 0;
            while (input.hasNextLine()) {
                // Split the line into elements.
                String[] elements = input.nextLine().split(",");
                // create the UPC nodes using elements [0] and [2] which is 1 and 3 in the csv
                RBNode UPC = new RBNode(Long.parseLong(elements[0]), elements[2]);
                // start the time.
                long startRBT = System.nanoTime();
                // insert using RBinsert 
                tree.RBInsert(UPC);
                // stop the timer. 
                long endRBT = System.nanoTime();
                // add to the runningtime
                totalRunTime = totalRunTime + (endRBT - startRBT);
            }
            // When its done print out the time it took to build the tree. 
            System.out.println("Total time elapsed for building tree : " + totalRunTime + " nanoseconds");
            input = new Scanner(new File("input.dat"));
            // create the search list using the input file
            ArrayList<RBNode> searchList = new ArrayList<RBNode>();
            //set the running time back to zero so we can start the run total again.
            totalRunTime = 0;

            while (input.hasNextLine()) {
                // split the elements into array
                String[] elements = input.nextLine().split(",");
                // assign the first element to keyVal
                long keyVal = Long.parseLong(elements[0]);
                // start the time.
                long startRBTSearch = System.nanoTime();
                // find it
                tree.treeSearch(tree.root, keyVal);
                // stop the time
                long endRBTSearch = System.nanoTime();
                // add to the running time
                totalRunTime = totalRunTime + (endRBTSearch - startRBTSearch);
                // add it to the searchList (first and third pieces in the .dat)
                searchList.add(new RBNode(Long.parseLong(elements[0]), elements[2]));
            }
            // print total time. 
            System.out.println("\nTotal time elapsed for searching : " + totalRunTime + " nanoseconds\n");
            for (RBNode result : searchList)
                System.out.println(result.data);
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}