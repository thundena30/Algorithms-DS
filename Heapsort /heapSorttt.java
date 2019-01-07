import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class heapSorttt{

	private static final String filename = "input_100.txt";
	private static final String filename2 = "input_1000.txt";
	private static final String filename3 = "input_5000.txt";
	private static final String filename4 = "input_10000.txt";
   private static final String filename5 = "input_50000.txt";
	private static final String filename6 = "input_100000.txt";
	private static final String filename7 = "input_500000.txt";
	
   
   

	private static List<Integer> heap = new ArrayList<>();
	private int heapsize;
   
   // method calls addNumbersToHeap
	public List<Integer> parseFile(String fileName) {
		try {
			Files.lines(Paths.get(fileName)).forEach(this::addNumbersToHeap);
            System.out.print(fileName + " results ");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return heap;
	}
   
   //splits all file in lines and adds every value in list
	public void addNumbersToHeap(String line) {
		String[] numbers = line.split(" ");
		for (String value : numbers) {
			if (!value.isEmpty()) {
				int number = Integer.parseInt(value);
				heap.add(number);
			}
		}
	}
   //  construct a max heap by starting with the last node that has children and iterates back to the reoot calling max-heapif for each node 
   // to ensure max heap property is maintained 
	public void heapsort(List<Integer> array) {
		buildMaxHeap(array);
		for (int currentIndex = array.size() - 1; currentIndex >= 0; currentIndex--) {
			swapParentNode(array, currentIndex);
			heapsize--;
			maxHeapify(array, 0);
		}
		System.out.println(array);
	}

	private void swapParentNode(List<Integer> array, int currentIndex) {
		int currentValue = value(array, currentIndex);

		int parentIndex = 0;
		int parentValue = value(array, parentIndex);

		swap(array, currentIndex, currentValue, parentIndex, parentValue);
	}
   // take unsorted array and turn it into maxheap
   // build max heap from list of data using buildMaxHeap function
	private void buildMaxHeap(List<Integer> array) {
		heapsize = array.size();
		for (int index = heapsize / 2 - 1; index >= 0; index--) {
			maxHeapify(array, index);
		}
	}
   // checks to see if new root node element is in correct place using heapify function
   // arranges node i and its subtrees to satisfy heap property
	private void maxHeapify(List<Integer> array, int currentIndex) {
		int leftIndex = leftIndex(currentIndex);
		int rightIndex = rightIndex(currentIndex);

		int currentValue = value(array, currentIndex);

		int largestValueIndex = currentIndex;
		int largestValue = currentValue;

		if (leftIndex < heapsize) {
			int leftValue = value(array, leftIndex);
			if (leftValue > currentValue) {
				largestValue = leftValue;
				largestValueIndex = leftIndex;
			}
		}

		if (rightIndex < heapsize) {
			int rightValue = value(array, rightIndex);
			if (rightValue > largestValue) {
				largestValue = rightValue;
				largestValueIndex = rightIndex;
			}
		}

		if (largestValueIndex != currentIndex) {
			swap(array, currentIndex, currentValue, largestValueIndex, largestValue);
			maxHeapify(array, largestValueIndex);
		}

	}
   
  // move largest value at root node to end of heap by swapping it with the last element in the array 
	private void swap(List<Integer> array, int currentIndex, int currentValue, int largestValueIndex,
			int largestValue) {
		array.set(currentIndex, largestValue);
		array.set(largestValueIndex, currentValue);
	}

	private int leftIndex(int currentIndex) {
		return currentIndex * 2 + 1;
	}

	private int rightIndex(int currentIndex) {
		return currentIndex * 2 + 2;
	}
 
    //returns element in array
	private int value(List<Integer> array, int index) {
		return array.get(index);
	}

   //starts in the main method 
	public static void main(String[] args) {  
      // constructor creates new object 
		heapSort test = new heapSort();
		long startTime = System.nanoTime();
      //start test.parseFile() that returns an array of integer- adds every # in an an array
		List<Integer> array = test.parseFile(filename);
		test.heapsort(array);
		long endTime = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Time for 100 numbers: " + (double)totalTime/1000000000.0 + " seconds");
		heap.clear();
		startTime = System.nanoTime();
		array = test.parseFile(filename2);
		test.heapsort(array);
      	endTime = System.nanoTime();
      	totalTime = endTime - startTime;
		System.out.println("Time for 1000 numbers: " + (double)totalTime/1000000000.0 + " seconds");
      heap.clear(); 
      startTime = System.nanoTime();
		array = test.parseFile(filename3);
      // last call...have all the nubmers from the file then apply alorithm to the array
		test.heapsort(array);
      	endTime = System.nanoTime();
      	totalTime = endTime - startTime;
		System.out.println("Time for 5000 numbers: " + (double)totalTime/1000000000.0 + " seconds");
      heap.clear(); 
      startTime = System.nanoTime();
		array = test.parseFile(filename4);
		test.heapsort(array);
      	endTime = System.nanoTime();
      	totalTime = endTime - startTime;
		System.out.println("Time for 10000 numbers: " + (double)totalTime/1000000000.0 + " seconds");
      heap.clear(); 
      startTime = System.nanoTime();
		array = test.parseFile(filename5);
		test.heapsort(array);
      	endTime = System.nanoTime();
      	totalTime = endTime - startTime;
		System.out.println("Time for 50000 numbers: " + (double)totalTime/1000000000.0 + " seconds");
      heap.clear(); 
      startTime = System.nanoTime();
		array = test.parseFile(filename6);
		test.heapsort(array);
      	endTime = System.nanoTime();
      	totalTime = endTime - startTime;
		System.out.println("Time for 100000 numbers: " + (double)totalTime/1000000000.0 + " seconds");
      heap.clear(); 
      startTime = System.nanoTime();
		array = test.parseFile(filename7);
		test.heapsort(array);
      	endTime = System.nanoTime();
      	totalTime = endTime - startTime;
		System.out.println("Time for 500000 numbers: " + (double)totalTime/1000000000.0 + " seconds");
      
      
	}
}