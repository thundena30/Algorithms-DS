/* Pratyusha Thundena
Linear and Binary Search Copy Lab
September 4,2018
*/

import java.util.*;
import java.io.*;
class Search {

    /**l 
    intArray original intArrayay
    l left value
    r right value
    x value to find
    **/
    static int binarySearch(int[] intArray, int l, int r, int x) {
        long beginningTime = System.nanoTime();
        
        //sorting algorithm
        bubbleSort(intArray);

        if (r >= l) {
            int middle = l + (r - l) / 2;

            // If the element is present at the  
            // middledle itself 
            if (intArray[middle] == x) {
                
                //calculate the time
                long endingTime = System.nanoTime();
                Double milliS=(endingTime - beginningTime)/1000000.0;
                System.out.println("Binary Search Time in Milli Seconds: "+milliS);
                return middle;

            }

            // If element is smaller than middle, then  
            // it can only be present in left subintArrayay 
            if (intArray[middle] > x) {
                return binarySearch(intArray, l, middle - 1, x);
            }
            // Else the element can only be present 
            // in right subintArrayay 
            return binarySearch(intArray, middle + 1, r, x);
        }

            long endingTime = System.nanoTime();
            Double milliS=(endingTime - beginningTime)/1000000.0;
            System.out.println("Binary Search Time in Milli Seconds: "+milliS);
        // We reach here when element is not present 
        //  in intArrayay 
        return -1;
    }

    /**l 
    intArray original intArrayay
    n maximum length
    x value to find
    **/
    static int linearSearch(int intArray[], int n, int x) {
        long beginningTime = System.nanoTime();
        int i;
        for (i = 0; i < n; i++) {
            if (intArray[i] == x) {
                
                //calcultes the time
                long endingTime = System.nanoTime();
                Double milliS=(endingTime - beginningTime)/1000000.0;
                System.out.println("Linear Search Time in Milli Seconds: "+milliS);
                return i;
            }
        }
        long endingTime = System.nanoTime();
        Double milliS=(endingTime - beginningTime)/1000000.0;
        System.out.println("Linear Search Time in Milli Seconds: "+milliS);
        
        return -1;
    }

    //sorting algorithm
    static void bubbleSort(int[] intArray) {  
        int n = intArray.length;  
        int temporaryorary = 0;  
         for(int i=0; i < n; i++){  
                 for(int j=1; j < (n-i); j++){  
                          if(intArray[j-1] > intArray[j]){  
                                 //swap elements  
                                 temporaryorary = intArray[j-1];  
                                 intArray[j-1] = intArray[j];  
                                 intArray[j] = temporaryorary;  
                         }  
                          
                 }  
         }  
  
    } 

    public static void main(String arg[]) {
        List<Integer> list = new ArrayList<Integer>();
        File file = new File("input_1000.txt");
        BufferedReader reader = null;

        try {

            //Reads the file
            reader = new BufferedReader(new FileReader(file));
            String text = null;
            while ((text = reader.readLine()) != null) {
                String[] str = text.split(" ");
                for (int i = 0; i < str.length; i++) {
                    
                    //storing values in list
                    list.add(Integer.parseInt(str[i]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
            }
        }

        //converts list into intArrayay
        int[] intArray=list.stream().mapToInt(Integer::intValue).toArray();
        
        
        int linearSearch=linearSearch(intArray,999,2);
        
        if(linearSearch==-1){
            System.out.println("Value not discovered");
        }else{
            System.out.println("Value discovered at position: "+(linearSearch+1));
        }

        int binarySearch=binarySearch(intArray, 0, 11, 2);
        
        if(binarySearch==-1){
            System.out.println("Value not discovered");
        }else{
            System.out.println("Value discovered at position: "+(binarySearch+1));
        }
    }
}
