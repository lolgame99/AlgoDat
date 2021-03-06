package sortingAlgos;

public class bubbleSort {
    public static int[] sort(int[] unsorted) {
        for (int i = 1; i < unsorted.length; i++) {
            for (int j = 0; j< unsorted.length-1; j++) {
                if(unsorted[j]>unsorted[j+1]){
                    swap(unsorted,j,j+1);
                }
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
