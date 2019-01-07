/*Pratyusha Thundena
October 9, 2018
Lab 6*/

class SortArray {

    void sortarray(int array[]) {
     
        int size = array.length;
   
     // iterate over array
     for (int i = 0; i <= size / 2; i++) {
   
      // Find the minimum element and maximum element index in unsorted array
      int min_index = i;
      int max_index = i;
      for (int j = i + 1; j < size - i; j++) {
       if (array[j] < array[min_index])
        min_index = j;
       if (array[j] > array[max_index])
        max_index = j;
   
   
      }
   
      // Swap the minimum element with the first element
      // and the maximum with the last element
   
      int temp = array[max_index];
      array[max_index] = array[size - i - 1];
      array[size - i - 1] = temp;
   
      int holder = array[min_index];
      array[min_index] = array[i];
      array[i] = holder;
   
     }
    }
   
    // print the array
    void printer(int array[]) {
     int size = array.length;
     for (int i = 0; i < size; ++i)
      System.out.print(array[i] + " ");
     System.out.println();
    }
   
    // Driver code to test the sorting algorithm
    public static void main(String args[]) {
     SortArray s = new SortArray();
     
     int array[] = {55,42,12,323,1,5,53,211,47};

     System.out.println("\nUnSorted array: ");
     s.printer(array);
     s.sortarray(array);
     System.out.println("\nSorted array: ");
     s.printer(array);
    }
}