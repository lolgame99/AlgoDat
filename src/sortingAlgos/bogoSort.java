package sortingAlgos;

import java.util.Random;

public class bogoSort {
    public static int[] sort(int[] unsorted) {
        for (int i = 1; i < unsorted.length; i++) {
            if (unsorted[i-1]>unsorted[i]) {
                shuffleArray(unsorted);
                i = 0;
            }
        }

        return unsorted;
    }

    private static void shuffleArray(int[] array)
    {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
