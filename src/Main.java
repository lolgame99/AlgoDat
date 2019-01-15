import sortingAlgos.selectionSort;

public class Main {

    public static void main(String[] args) {
        int[] array = DataGenerator.generateDataArray(1000, 0, 1000);

        DataGenerator.printArray(array);
        System.out.println("------------------------------------------------------------------------------------");

        DataGenerator.printArray(selectionSort.sort(array));

    }
}