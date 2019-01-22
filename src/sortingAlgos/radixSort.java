package sortingAlgos;

import java.util.ArrayList;
import java.util.List;

public class radixSort {
    public static int[] sort(int[] unsorted) {
        for (int shift = Integer.SIZE - 1; shift > -1; shift--) {
            int[] tmp = new int[unsorted.length];
            int j = 0;

            for (int i = 0; i < unsorted.length; i++) {
                boolean move = unsorted[i] << shift >= 0;

                if (shift == 0 ? !move : move) {
                    tmp[j] = unsorted[i];
                    j++;
                } else {
                    unsorted[i - j] = unsorted[i];
                }
            }

            for (int i = j; i < tmp.length; i++) {
                tmp[i] = unsorted[i - j];
            }

            unsorted = tmp;
        }

        return unsorted;
    }
}
