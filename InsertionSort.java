public class InsertionSort implements SortingAlgorithm
{
    public void sort(int [] a) {
        for (int i = 1; i < a.length; i++) {
            int index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > a[index]) {
                    swap(a, j, index);
                    index = j;
                }
            }
        }
    }
    public void swap(int [] a , int n, int m)
    {
        int temp = a [m];
        a[m]= a[n];
        a[n]= temp;
    }
}
