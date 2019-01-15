import java.util.ArrayList;
import java.util.Random;

public class DataGenerator {

    public static Random random = new Random();

    public static  int[] generateDataArray (int size){
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt();
        }

        return result;
    }

    public static int[] generateDataArray (int size, int min, int max){
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = random.nextInt((max - min) + 1) + min;
        }

        return result;
    }

    public static void printArray ( int[] arr){
        for (int num: arr
             ) {
            System.out.println(num);
        }
    }

}
