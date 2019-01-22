package sortingAlgos;

public class selectionSort{

    public static int[] sort(int[] unsorted) {
        int[] arr = unsorted;
        for (int j = 0; j < arr.length-1; j++) {
            int min = j;

            for (int i = j+1; i < arr.length; i++) {
                if(arr[i]<arr[min]){
                    min = i;
                }
                
            }

            if(min!=j){
                swap(arr,j,min);
            }
        }
        
        return arr;
    }

    private static final void swap (int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
