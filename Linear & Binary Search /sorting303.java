/* Pratyusha Thundena
August 29, 2018
Assignment 1
 */

import java.util.Arrays;
import java.util.Random;

public class sorting303 {
    static Random random = new Random();

    public static void main(String[] args){
        int aLinearCount = 0;
        int aBinaryCount = 0;
        for (int i = 0; i < 50; i++) {
            int[] dataArray = generateRandomArrayWithRandomNum();
            int search = random.nextInt(1000);
            int linearCount = performLinearSearch(dataArray, search);
            int binaryCount = performBinarySearch(dataArray, search);
            System.out.println("Linear : "+linearCount);
            System.out.println("Binary : "+binaryCount);
            aLinearCount+=linearCount;
            aBinaryCount+=binaryCount;
        }
        System.out.println("\nThe average # of checks for 50 was:");
        System.out.println("Linear Search "+aLinearCount/50);
        System.out.println("Binary Search "+aBinaryCount/50);
    }

    private static int[] generateRandomArrayWithRandomNum() {
        int size = random.nextInt(1000);
        int[] dataArray = new int[size];
        for (int i = 0; i < size; i++) {
            dataArray[i] = random.nextInt(1000);
        }
        Arrays.sort(dataArray);
        return dataArray;
    }

    private static int performLinearSearch(int[] dataArray, int search) {
        System.out.println("Linear Search Results");
        int count = 0;
        boolean found = false;
        for (int i = 0; i < dataArray.length; i++) {
            count++;
            if (dataArray[i] == search) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Found!");
        } else {
            System.out.println("Not Found!");
        }
        return count;
    }

    private static int performBinarySearch(int[] dataArray, int search) {
        System.out.println("Binary Search Results");
        int count = 0;
        boolean found = false;
        int high = dataArray.length-1;
        int low = 0;
        int mid = 0;
        while (low <= high) {
            count++;
            mid = (low + high) / 2;
            if (dataArray[mid] > search) {
                high = mid - 1;
            } else if (dataArray[mid] < search) {
                low = mid + 1;
            } else {
                found = true;
                break;
            }
        }
        if(found){
            System.out.println("Discovered!");
        }else{
            System.out.println("Not Discovered!");
        }
        return count;
    }
}