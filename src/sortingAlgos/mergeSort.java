package sortingAlgos;

import java.util.Arrays;

public class mergeSort {

    public int[] sort(int[] array) {
        if(array.length == 1){
            return array;
        }

        int split = array.length / 2;

        int length1 = split;
        int length2 = array.length - split;

        int[] arr1 = partArray(array, 0, length1);
        int[] arr2 = partArray(array, split, length2);

        if(arr1.length > 1){
            arr1 = sort(arr1);
        }
        if(arr2.length > 1){
            arr2 = sort(arr2);
        }

        return merge(arr1, arr2);
    }

    // ----------------------------------------------------

    private int[] merge(int[] arr1, int[] arr2){
        int[] sorted = new int[arr1.length + arr2.length];
        int a = 0;
        int b = 0;
        int c = 0;

        while(a < arr1.length && b < arr2.length){
            if(arr1[a] < arr2[b]){
                sorted[c] = arr1[a];
                a++;
            }
            else{
                sorted[c] = arr2[b];
                b++;
            }
            c++;
        }

        while(a < arr1.length){
            sorted[c] = arr1[a];
            a++;
            c++;
        }
        while(b < arr2.length){
            sorted[c] = arr2[b];
            b++;
            c++;
        }

        return sorted;
    }

    // ----------------------------------------------------

    private int[] partArray(int[] array, int position, int size){
        int[] newArray = new int[size];
        System.arraycopy(array, position, newArray, 0, size);

        return newArray;
    }
}
