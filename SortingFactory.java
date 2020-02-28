public class SortingFactory
{

   public final String defaultAlgorithm = "InsertionSort";  // If an improper algorithm name is given, which should be used?
    public boolean useDefault = false;   // ... and should it be done?

    public SortingFactory(boolean returnDefault)
    {
        // If the client does not provide a proper algorithm name: use the default, or return an error?
        useDefault = returnDefault;
    }

    public static SortingAlgorithm getSortingAlgorithm(String algoName) throws Exception
    {
        String lowercaseAlgoName = algoName.toLowerCase();

        if (lowercaseAlgoName.contains("merge"))
        {
            return new MergeSort();
        }
        if (lowercaseAlgoName.contains("quick"))
        {
            return new QuickSort();
        }
        if (lowercaseAlgoName.contains("insertion"))
        {
            return new InsertionSort();
        }

        return null;
    }



}