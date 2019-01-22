package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sortingAlgos.*;
import util.*;

import static org.junit.jupiter.api.Assertions.*;

public class sortingTests {
    //CONFIG
    private static final int COUNTREP = 1; //Anzahl Wiederholungen
    private static final int COUNTDATA = 100000; //Anzahl Datensätze pro Wiederholung

    private static final boolean ENABLEBOGO = false; //Aktivierung Bogo Sorting !!WARNING SLOW!!
    private static final boolean ENABLEINSERT = false; //Aktivierung Insert Sorting
    private static final boolean ENABLESELECT = false; //Aktivierung Selection Sorting
    private static final boolean ENABLEBUBBLE = false; //Aktivierung Bubble Sorting
    private static final boolean ENABLERADIX = true; //Aktivierung Radix Sorting


    static int[][] unsorted = new int[COUNTREP][COUNTDATA];


    @BeforeAll
    public static void testSetup(){
        int[] arr = new int[COUNTDATA];
        for (int i = 0; i < COUNTREP; i++) {
            arr = DataGenerator.generateDataArray(COUNTDATA,0,100000);
            for (int j = 0; j < arr.length-1; j++) {
                unsorted[i][j] = arr[j];
            }
        }
    }

    @Test
    public void selectionTest(){
        if (ENABLESELECT){
            double time = sort(unsorted,0);
            success("Selection Sort",time);
        }
    }

    @Test
    public void bubbleTest(){
        if (ENABLEBUBBLE){
            double time = sort(unsorted, 2);
            success("Bubble Sort",time);
        }
    }

    @Test
    public void insertionTest(){
        if (ENABLEINSERT){
            double time = sort(unsorted, 1);
            success("Insertion Sort",time);
        }
    }

    @Test
    public void radixTest(){
        if (ENABLERADIX){
            double time = sort(unsorted, 4);
            success("Radix Sort",time);
        }
    }

    @Test
    public void bogoTest(){
        if (ENABLEBOGO) {
            double time = sort(unsorted,3);
            success("Bogo Sort", time);
        }
    }


    private void check(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1]>arr[i]){
                int j=i-1;
                fail("Error between index "+j+"and"+i+"\nNumbers: "+arr[i-1]+" | "+arr[i]);
            }
        }
    }

    private double sort(int[][] arr,int type){
        int[] sorted = new int[COUNTDATA];
        double time = 0;
        int[][] clone = arr.clone();
        for (int i = 0; i < COUNTREP; i++) {
            int[] unsClone = clone[i];
            Stopwatch sw = new Stopwatch();

            switch (type){
                case 0:
                    sorted = selectionSort.sort(unsClone);
                    break;
                case 1:
                    sorted = insertionSort.sort(unsClone);
                    break;
                case 2:
                    sorted = bubbleSort.sort(unsClone);
                    break;
                case 3:
                    sorted = bogoSort.sort(unsClone);
                    break;
                case 4:
                    sorted = radixSort.sort(unsClone);
                    break;
                default:
                    break;
            }

            time += sw.elapsedTime();
            check(sorted);
        }
        time = time/COUNTREP;
        return time;
    }

    private void success(String type, double time){
        System.out.println(type + " Successful - AVG. Time: " + String.format( "%.4f", time ));
    }
}
