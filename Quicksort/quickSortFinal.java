/*Pratyusha Thundena
QuickSort Lab HW
October 2, 2018 
*/

import java.io.*;
import java.util.*;

// Java program for implementation of 2 QuickSort methods 
class quickSort {

    private static final String filename = "input_100.txt";
    private static final String filename2 = "input_1000.txt";
    private static final String filename3 = "input_5000.txt";
    private static final String filename4 = "input_10000.txt";
    private static final String filename5 = "input_50000.txt";
    private static final String filename6 = "input_100000.txt";
    private static final String filename7 = "input_500000.txt";
    private static final String filename8 = "Input_Random.txt";
    private static final String filename9 = "Input_ReversedSorted.txt";
    private static final String filename10 = "Sorted.txt";
    
    
   // method for  calling partiiton in basic quicksort 
    public static void QUICKSORT(List< Integer> A, int p, int r) {
        if (p < r) {
            int q = PARTITION(A, p, r);
            QUICKSORT(A, p, q - 1);
            QUICKSORT(A, q + 1, r);
        }

    }
   // method for partition algorithm for quicksort
    private static int PARTITION(List< Integer> A, int p, int r) {
        int x = A.get(r);
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (A.get(j) <= x) {
                i++;
                int temp = A.get(i);
                A.set(i, A.get(j));
                A.set(j, temp);

            }
        }

        int temp = A.get(i + 1);
        A.set(i + 1, A.get(r));
        A.set(r, temp);
        return i + 1;
    }
   //method for quicksort algorithm using median of 3 partitioning 
    public static void Quicksort(List< Integer> A, int p, int r) {
        if (p < r) {
            int N = r - p + 1;
            int m = Median3(A, p, p + N / 2, r);
            int temp = A.get(m);
            A.set(m, A.get(r));
            A.set(r, temp);
            int q = PARTITION(A, p, r);
            Quicksort(A, p, q - 1);
            Quicksort(A, q + 1, r);

        }

    }
   // method that returns the median value in 3 way partitioning quicksort 
    private static int Median3(List< Integer> A, int p, int i, int r) {
        int mid = (p + r + i) / 3;
        return A.get(mid);
    }
   // parseFile method allows you to scan and sort numbers without errors 
    public static List< Integer> parseFile(String filename) {
        List< Integer> list = new ArrayList<Integer>();
        try {
            Scanner in = new Scanner(new File(filename));
            while (in.hasNextInt()) {
                list.add(in.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open file");
        }
        return list;

    }

    // Driver program
    public static void main(String args[]) {

        List<String> files = new ArrayList<String>();
        files.add(filename);
        files.add(filename2);
        files.add(filename3);
        files.add(filename4);
        files.add(filename5);
        files.add(filename6);
        files.add(filename7);
        files.add(filename8);
        files.add(filename9);
        files.add(filename10);
        long startTime = 0, endTime = 0, totalTime = 0;
        List<Integer> array = new ArrayList<Integer>();
		
        System.out.println("Results for first method:");
        for (String file : files) {
            String name = file.replace("input_", "").replace("Input_", "").replace(".txt", "");
            startTime = System.nanoTime();
            array = parseFile(filename);
            QUICKSORT(array, 0, array.size() - 1);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            System.out.println("Time for " + name + " : " + (double) totalTime / 1000000000.0 + " nanoseconds");
        }
        System.out.println("Results for second method:");
        for (String file : files) {
            String name = file.replace("input_", "").replace("Input_", "").replace(".txt", "");
            startTime = System.nanoTime();
            array = parseFile(filename);
            Quicksort(array, 0, array.size() - 1);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            System.out.println("Time for " + name + " : " + (double) totalTime / 1000000000.0 + " nanoseconds");
        }
		
    }
}
