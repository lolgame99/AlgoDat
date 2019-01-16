package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sortingAlgos.*;
import util.*;

import static org.junit.jupiter.api.Assertions.*;

public class sortingTests {
    //CONFIG
    private static final int COUNTREP = 10; //Anzahl Wiederholungen
    private static final int COUNTDATA = 50000; //Anzahl Datensätze pro Wiederholung
    private static final boolean ENABLEBOGO = false; //Aktivierung Bogo Sorting !!WARNING SLOW!!


    static int[][] unsorted = new int[COUNTREP][COUNTDATA];


    @BeforeAll
    public static void testSetup(){
        int[] arr = new int[COUNTDATA];
        for (int i = 0; i < COUNTREP; i++) {
            arr = DataGenerator.generateDataArray(COUNTDATA);
            for (int j = 0; j < arr.length-1; j++) {
                unsorted[i][j] = arr[j];
            }
        }
    }

    @Test
    public void selectionTest(){
        int[] sortedS = new int[COUNTDATA];
        double time = 0;
        for (int i = 0; i < COUNTREP; i++) {
            Stopwatch sw = new Stopwatch();
            sortedS = selectionSort.sort(unsorted[i]);
            time += sw.elapsedTime();
            check(sortedS);
        }
        time = time/COUNTREP;
        success("Selection Sort",time);
    }

    @Test
    public void bubbleTest(){
        int[] sortedB = new int[COUNTDATA];
        double time = 0;
        for (int i = 0; i < COUNTREP; i++) {
            Stopwatch sw = new Stopwatch();
            sortedB = bubbleSort.sort(unsorted[i]);
            time += sw.elapsedTime();
            check(sortedB);
        }
        time = time/COUNTREP;
        success("Bubble Sort",time);
    }

    @Test
    public void insertionTest(){
        int[] sortedI = new int[COUNTDATA];
        double time = 0;
        for (int i = 0; i < COUNTREP; i++) {
            Stopwatch sw = new Stopwatch();
            sortedI = insertionSort.sort(unsorted[i]);
            time += sw.elapsedTime();
            check(sortedI);
        }
        time = time/COUNTREP;
        success("Insertion Sort",time);
    }


    @Test
    public void bogoTest(){
        if (ENABLEBOGO) {
            int[] sorted = new int[COUNTDATA];
            double time = 0;
            for (int i = 0; i < COUNTREP; i++) {
                Stopwatch sw = new Stopwatch();
                sorted = bogoSort.sort(unsorted[i]);
                time += sw.elapsedTime();
                check(sorted);
            }
            time = time/COUNTREP;
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

    private void success(String type, double time){
        System.out.println(type + " Successful - AVG. Time: " + time);
    }
}
