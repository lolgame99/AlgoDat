package sortingAlgos;

public class insertionSort {
    public static int[] sort(int[] unsorted) {
        for (int i = 0; i < unsorted.length; i++) {
            int j = i;

            while(j>0&&unsorted[j-1]>unsorted[j]){
                swap(unsorted,j,j-1);
                j--;
            }
        }

        return unsorted;
    }

    private static final void swap (int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
