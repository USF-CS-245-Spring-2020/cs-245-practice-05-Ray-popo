public class QuickSort implements SortingAlgorithm
{
    public void sort(int [] a)
    {
        //check if it's an empty array
        if ((a== null) ||  (a.length == 0))
        {
            return;
        }
        else
        {
            quickSort(a,0, a.length - 1);
        }
    }
    public void quickSort(int [] arr,int start, int end)
    {
        int i = start;
        int j = end;
        //if pivot is in the mid of the array(quickest)
        int pivot = arr[start+(end - start)/2];
        //divide the whole array into two arrays
        while(i<=j)
        {
           // Will identify a number from left side and greater than the pivot,
           //and also a number from right side which is less than the pivot,
           //will have a swap function for swap both numbers once it is complete
           while(arr[i]<pivot)
           {
               i+=1;
           }
           while(arr[j]>pivot)
           {
               j-=1;
           }
           if(i<=j)
           {
               //swap the position on both sides
               swap(arr,i,j);
               i+=1;
               j-=1;
           }
        }
        //recursive back into the quickSort function
        if (start <j)
        {
            quickSort(arr,start,j);
        }
        if (i<end)
        {
            quickSort(arr,i,end);
        }
    }
    //for swaping the value from  the both side
    public void swap(int []brr, int i,int j)
    {
        int temp = brr[i];
        brr[i] = brr[j];
        brr[j] = temp;

    }
}
