/*Pratyusha Thundena
December 5, 2018
Lab 14 */

import java.util.Scanner;

public class Lab14 
{	
	// the method to compute the nCr
	public static int nCrDynamicProgramming(int n,int r)
	{
		/* the idea of dynamic programming is I am calculating values that are run 
		dynamically.
		 */
		
		// create a 2d array
		// I can use this 2d array to build values using the previous ones
		// these values are built iteratively
      
		
		int[][] C = new int[ n+1 ][ r+1 ];
		
		// build the solution iteratively
		for( int i=0; i<=n; i++)
		{
			for( int j=0; j<=Math.min(i, r); j++)
			{
				// if these are the boundary values
				if( j == 0 || j == i )
					C[i][j] = 1;
				else
					C[i][j] = C[i-1][j-1] + C[i-1][j];
			}
		}
		
		return C[n][r];
	}
	
	// the main method
	public static void main(String args[])
	{
		// scanner to read from the user
		Scanner scanner = new Scanner(System.in);
		
		// ask for the value of n
		System.out.print("Enter the value of n : ");
		int n = scanner.nextInt();
		
		System.out.print("Enter the value of r : ");
		int r = scanner.nextInt();
		
		// print 
		System.out.println("Valud of " + n + "C" + r + " = " + nCrDynamicProgramming(n, r));
		
		
		// close the scanner
		scanner.close();
	}

}