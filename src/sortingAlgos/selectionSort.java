package sortingAlgos;

public class selectionSort{

    public static int[] sort(int[] unsorted) {
        for (int j = 0; j < unsorted.length-1; j++) {
            int min = j;

            for (int i = j+1; i < unsorted.length; i++) {
                if(unsorted[i]<unsorted[min]){
                    min = i;
                }
                
            }

            if(min!=j){
                swap(unsorted,j,min);
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
