package lab14;

import java.util.Scanner;

public class BinomialCoefficentRecursion
{
	public BinomialCoefficentRecursion()
	{
		
	}
	
	public static int binomialCoeff(int n, int k)
	{
		if (k == 0 || k == n)
		{
			return (1);
		}
		else
		{
			return (binomialCoeff(n-1, k-1) + binomialCoeff(n-1, k));
		}
	}
	
	public static void main(String[] args)
	{
       Scanner in = new Scanner(System.in); 
       System.out.printf("Enter n Value:  ");
       int n = in.nextInt();
       System.out.printf("Enter k Value:  ");
       int k = in.nextInt();
       in.close();
       
       int binomialCoefficent = binomialCoeff(n, k);
       
       System.out.println("Binomial coefficent is: " + binomialCoefficent);
	}
}

