/* Pratyusha Thundena
CS 303 Lab #3
September 18,2018
*/




import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;

public class mergeSortNew {

	public static void main(String args[]) throws FileNotFoundException {

		int arr[], temp[];

		String Filename[] =

				new String[] { "input_100.txt", "input_1000.txt", "input_5000.txt", "input_10000.txt",
						"input_50000.txt", "input_100000.txt", "input_500000.txt" };

		// Save filenames in a variable

		double times[] = new double[Filename.length];

		int file1 = 0, file2 = 0, file3 = 0, file4 = 0, file5 = 0, file6 = 0,

				file7 = 0;

		Scanner number;

		for (int n = 0; n < Filename.length; n++) {

			int mySum = 0;

			number = new Scanner(new File(Filename[n]));

			while (number.hasNextInt()) {

				int x = number.nextInt();

				// save values from file

				mySum++;

				// increments the value by 1 for each new value

			}

			// close the scanner

			if (n == 0) {

				file1 = mySum;

			}

			else if (n == 1) {

				file2 = mySum;

			}

			else if (n == 2) {

				file3 = mySum;

			}

			else if (n == 3) {

				file4 = mySum;

			}

			else if (n == 4) {

				file5 = mySum;

			}

			else if (n == 5) {

				file6 = mySum;

			}

			else if (n == 6) {

				file7 = mySum;

			}

			number.close();

		}

		int index[] = { file1, file2, file3, file4, file5, file6, file7 };

		for (int n = 0; n < Filename.length; n++) {

			arr = new int[index[n]];

			temp = new int[index[n]];

			long beginTime, finishTime, totalTime;

			// declare variables to save time

			System.out.println("File");

			number = new Scanner(new File(Filename[n]));

			if (n == 0) {

				for (int i1 = 0; i1 < file1; i1++)

					arr[i1] = Integer.parseInt(number.next());

			}

			else if (n == 1) {

				for (int i2 = 0; i2 < file2; i2++)

					arr[i2] = Integer.parseInt(number.next());

			} else if (n == 2) {

				for (int i3= 0; i3 < file3; i3++)

					arr[i3] = Integer.parseInt(number.next());

			} else if (n == 3) {

				for (int i4 = 0; i4 < file4; i4++)

					arr[i4] = Integer.parseInt(number.next());

			} else if (n == 4) {

				for (int i5 = 0; i5 < file5; i5++)

					arr[i5] = Integer.parseInt(number.next());

			} else if (n == 5) {

				for (int i6 = 0; i6 < file6; i6++)

					arr[i6] = Integer.parseInt(number.next());

			} else if (n == 6) {

				for (int i7 = 0; i7 < file7; i7++)

					arr[i7] = Integer.parseInt(number.next());

			}

			beginTime = System.nanoTime();
         // set the insertionLimit to 10...experimenting . 1000 might be too fast. 
			int insertionLimit = 100;
			merge_sorting(arr, temp, 0, index[n] - 1, insertionLimit);

			finishTime = System.nanoTime();

			totalTime = finishTime - beginTime;

			times[n] = totalTime / 1000000;

			System.out.println("Recorded time : " + times[n] +

					" milliseconds to sort file " + Filename[n]);

			number.close();

			// modified mergeSort- falls to insertionSort when the number is small 

			// runs insertion sort algorithm

			for (int i = 0; i < arr.length; i++)

			{

				System.out.print(arr[i] + " ");

			}

			System.out.println("\n");

		}

		System.out.println("\n\nSorting complete");

	}

	// function to sort array using merge sort

	public static void merge_sorting(

			int arr[], int temp[], int low,

			int high, int insertionLimit) { // lower index and higher index as argument to the function

				// speed up here 
            // remove this if statement and it goes back to normal mergeSort
            //insertionLimit is a method parameter
				if (arr.length <= insertionLimit) {
					insertionSort(arr);
               System.out.println("This is insertion sort."); 
					return;
				}

				if (low < high) { // calculating if low>high then the array will be sorted

			// else sort the array

			int mid = low + (high - low) / 2; // calculate mid index to break the array into two halves

			merge_sorting(arr, temp, low, mid, insertionLimit); // calling sorting function to sort the left subarray

			merge_sorting(arr, temp, mid + 1, high, insertionLimit); // calling sorting function to sort the right subarray

			merge(arr, temp, low, mid, high); // calling function to merge two subarrays
     

		}

	}

	public static void merge(int arr[], int temp[], int low, int m,

			int high) { // merging function

		
		
				for (int i = 0; i <= high; i++) { // copying the value of the array in a temporary array ar1

			temp[i] = arr[i];

		}

		int i = low, j = m + 1, k = low; // initializing variable

		while (i <= m && j <= high) { // checking if the value of i is less than mid index and value of j is less than
										// higher index

			if (temp[i] <= temp[j]) { // swap the values

				arr[k] = temp[i]; // put the sorted value in the original array

				i++; // increment loop variable

			}

			else {

				arr[k] = temp[j]; // copy content of temporary variable to original

				// array

				j++; // increment loop variable

			}

			k++;

		}

		while (i <= m) { // if value of i is less than the mid index then copy value of temporary array
							// to the original array

			arr[k] = temp[i];

			k++; // increment loop variable

			i++;

		}

	}

	public static void insertionSort(int array[]) {

		int n = array.length;

		// declare array length

		for (int j = 1; j < n; j++) {

			// intialize the loop to sort

			int key = array[j];

			int i = j - 1;

			while ((i > -1) && (array[i] > key)) {

				array[i + 1] = array[i];

				i--;

			}

			array[i + 1] = key;

			// the first element is given the smallest value

		}

	}

}
 