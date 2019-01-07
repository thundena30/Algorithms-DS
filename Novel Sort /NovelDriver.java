/*Pratyusha Thundena
October 9. 2018
Lab 6*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class NovelDriver {
  
   public static void main(String[] args) throws IOException{
       // read the file
       FileReader in = new FileReader("NovelSortInput.txt");
       
       BufferedReader a = new BufferedReader(in);
  
       String aString;
      
       List<String> list = new ArrayList<String>();
       // creates the list to use with the novel sort, but reading
       // the file until its null.
       while((aString = a.readLine()) != null){
           list.add(aString);
       }
       // close filereaders.
       in.close();
       // the final file to be sort.
       String[] finalstring = list.toArray(new String[0]);

       NovelSort.novelSort(finalstring);
       // print out the sorted array.
       System.out.print(Arrays.toString(finalstring));
   }

}