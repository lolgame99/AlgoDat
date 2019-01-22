package sortingAlgos;

import java.util.ArrayList;
import java.util.List;

public class radixSort {
    public static int[] sort(int[] unsorted) {
        // Loop for every bit in the integers
        for (int shift = Integer.SIZE - 1; shift > -1; shift--) {
            // The array to put the partially sorted array into
            int[] tmp = new int[unsorted.length];
            // The number of 0s
            int j = 0;

            // Move the 0s to the new array, and the 1s to the old one
            for (int i = 0; i < unsorted.length; i++) {
                // If there is a 1 in the bit we are testing, the number will be negative
                boolean move = unsorted[i] << shift >= 0;

                // If this is the last bit, negative numbers are actually lower
                if (shift == 0 ? !move : move) {
                    tmp[j] = unsorted[i];
                    j++;
                } else {
                    // It's a 1, so stick it in the old array for now
                    unsorted[i - j] = unsorted[i];
                }
            }

            // Copy over the 1s from the old array
            for (int i = j; i < tmp.length; i++) {
                tmp[i] = unsorted[i - j];
            }

            // And now the tmp array gets switched for another round of sorting
            unsorted = tmp;
        }

        return unsorted;
    }
}
