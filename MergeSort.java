public class MergeSort implements SortingAlgorithm
{
    public void sort(int [] a) {
        int low =0;
        int high  = a.length ;
        //set up the size of the array
        mergeSort(a, low , high-1);
    }
    //set up an helping
    public void mergeSort(int [] arr, int left, int right)
    {
        int mid = (left+right)/2;
        if (left <right)
        {
            mergeSort(arr, left, mid); //step sorts the left side of the array
            mergeSort(arr, mid + 1, right);//step sorts the right side of the array
            //combine
            merge(arr, left, mid, right);// method for merge and swap
        }
        //<2 do not need to sort
        else
            return;
    }
    public void merge(int []arr, int start, int mid, int end)
    {
        int [] temp = new int[end -start +1];
        int i = start;
        int j = mid+1;
        int k =0;
        //merge back and compare each item for equality
        while (i<=mid && j<=end)
        {
            if (arr[i]<= arr[j])
            {
                temp [k]= arr[i];
                k+=1;
                i+=1;
            }
            else
            {
                temp[k] = arr[j];
                k+=1;
                j+=1;
            }
        }
        //any remaining loop checking
        //left remaining
        while (i<= mid)
        {
            temp [k] = arr[i];
            k+=1;
            i+=1;
        }
        //right remaining
        while (j<=end)
        {
            temp[k] = arr[j];
            k+=1;
            j+=1;
        }
        //copy No,s back to the array
        for(i = start; i<=end; i+=1)
        {
            arr[i] = temp[i-start];
        }
    }

}
