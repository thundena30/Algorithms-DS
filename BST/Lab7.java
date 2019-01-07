/*Pratyusha Thundena
October 16, 2018
Lab 7 HW */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab7 {

	public static void main(String[] args) {
      // read through UPC file 
		try {
         // constructor that instantiates the object tree 
			BST tree = new BST();
			Scanner input;
			input = new Scanner(new File("UPC.csv"));
			long totalRunTime = 0;
			while (input.hasNextLine())
			{
				String[] elements = input.nextLine().split(",");
            // constructor that parses stringed argument as a signed decimal long and returns a long value
				Binary UPC = new Binary(Long.parseLong(elements[0]), elements[2]);
				tree.insert(UPC);	
			}
         // read through input.dat file 
			input = new Scanner(new File("input.dat"));	
         // constructor that finds an element within the list 
			ArrayList<Binary> searchList = new ArrayList<Binary>();	
			while (input.hasNextLine())
			{
				String[] elements = input.nextLine().split(",");
				long keyVal = Long.parseLong(elements[0]);
				long startSearch = System.nanoTime();
				tree.search(tree.root, keyVal);
				long endSearch = System.nanoTime();
				totalRunTime = totalRunTime + (endSearch - startSearch);
				searchList.add(new Binary(Long.parseLong(elements[0]), elements[2]));
			}
         // print out total time for searching 
			System.out.println("\nTotal time elapsed for searching : " + totalRunTime + " nanoseconds\n");
			for (Binary result : searchList)
				System.out.println(result.data);
			input.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
	
class Binary {
		long key;
		Binary left, right;
		String data;
		
      // method that defines key as keys and data as words
		public Binary (long keys, String words) {
			key = keys;
			data = words;
			left = null;
			right = null;
		}
}		

class BST {
    Binary root;
		// method that defines the root as null 
		BST(){
			root = null;
		}		
     // method that inserts a node having value of key = data in BST
 
		void insert(Binary z)
		{
			Binary y = null;
			Binary x = root;
			while (x != null)
			{
				y = x;
				if (z.key < x.key)
					x = x.left;
				else
					x = x.right;
			}
				//z.p = y;
				if ( y == null)
					root = z;
				else if (z.key < y.key)
					y.left = z;
				else 
					y.right = z;
              
		}
      // method that prints the elements of the BST in an in-order format
		void inOrder(Binary x) 
		{
			if (x != null)
			{
				inOrder(x.left);
				System.out.print(x.key + " ");
				inOrder(x.right);
			}
		}
      // method that searches for a node having value of key = data in BST

		Binary search(Binary x, long k)
		{
			if (x == null || k == x.key)
				return x;
			if (k < x.key)
				return search(x.left, k);
			else
				return search(x.right,k);
		}
}