import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.*;
import java.util.Arrays;
import java.util.Random;
import java.text.DecimalFormat;


public class MegaSort
{
    static SortingFactory factory;

    public static void main (String [] args )
    {
        try
        {
            File file = new File("/Users/mm/Desktop/245/P5/cs-245-practice-05-Ray-popo/1m-ints.txt");
            if (file.exists())
            {
                long fileLength  = file.length();
                LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));
                lineNumberReader.skip(fileLength);
                int lines = lineNumberReader.getLineNumber();
                //System.out.println("Total number of lines : " + lines);
                lineNumberReader.close();
                FileReader fileReader = new FileReader("/Users/mm/Desktop/245/P5/cs-245-practice-05-Ray-popo/1m-ints.txt");
                BufferedReader buf = new BufferedReader(fileReader);
                String readLine = "";
                String [] a = new String [lines];
                int i = 0;
                while ((readLine =  buf.readLine())!=null)
                {
                    a[i]=readLine;
                    i++;
                }
                //System.out.println(Arrays.toString(a));
                int [] arr = new int[lines];
                for(int j=0; j< lines;j++)
                {
                    arr[j] = Integer.parseInt(a[j]);
                }

                //System.out.println(Arrays.toString(arr));
                final int [] temp = (int []) arr.clone();
                //output the sorted list
                quick_Sort.sort(arr);
                System.out.println(Arrays.toString(arr));
                sortingTime(temp);
                //first three output lines
                for (int k=0;k<3;k++)
                {
                    String str1 = new DecimalFormat("0000").format(arr[k]);
                    System.out.println(str1);
                }

            }else {
                System.out.println("File does not exists!");
            }

        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }
    public static void sortingTime(int [] passTemp)
    {
        String [] algorithms = { "quicksort", "mergesort"};
        for (String algo : algorithms) {
            try {
                SortingAlgorithm sort = factory.getSortingAlgorithm(algo);
                System.out.print(algo+" time is: " + "\t");
                // For each algorithm:
                // a) Copy the array
                // b) Have the algorithm sort the copy ... while timing it.
                long start = System.currentTimeMillis();
                sort.sort(passTemp);
                // System.out.println("Sorting took: " + (System.currentTimeMillis() - start) + " ms.");
                long total_time = System.currentTimeMillis() - start;
                System.out.print(total_time + " ms.\t\n");

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Unable to instantiate sorting algorithm " + algo);
            }
        }
    }
}
