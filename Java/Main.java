import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static int repNr = 10;

    static void testTime(ArrayList<Integer> arr) {
        ArrayList<Integer> copy;
        long startTime;
        long estimatedTime0 = 0, estimatedTime1 = 0, estimatedTime2 = 0,
                estimatedTime3 = 0, estimatedTime4 = 0, estimatedTime5 = 0,
                estimatedTime6 = 0, estimatedTime7 = 0, estimatedTime8 = 0,
                estimatedTime9 = 0;

        for (int i = 0; i < repNr; i++) {

            copy = new ArrayList<>(arr);
            startTime = System.nanoTime();
            Sort.bubbleSort(copy);
            estimatedTime0 += System.nanoTime() - startTime;

            copy = new ArrayList<>(arr);
            startTime = System.nanoTime();
            Sort.insertionSort(copy);
            estimatedTime1 += System.nanoTime() - startTime;

            copy = new ArrayList<>(arr);
            startTime = System.nanoTime();
            Sort.selectionSort(copy);
            estimatedTime2 += System.nanoTime() - startTime;

            copy = new ArrayList<>(arr);
            startTime = System.nanoTime();
            Sort.quickSortRec(copy);
            estimatedTime3 += System.nanoTime() - startTime;

            copy = new ArrayList<>(arr);
            startTime = System.nanoTime();
            Sort.quickSortIter(copy);
            estimatedTime4 += System.nanoTime() - startTime;

            copy = new ArrayList<>(arr);
            startTime = System.nanoTime();
            Sort.topDownMergeSort(copy);
            estimatedTime5 += System.nanoTime() - startTime;

            copy = new ArrayList<>(arr);
            startTime = System.nanoTime();
            Sort.bottomUpMergeSort(copy);
            estimatedTime6 += System.nanoTime() - startTime;

            copy = new ArrayList<>(arr);
            startTime = System.nanoTime();
            Sort.shellSort(copy);
            estimatedTime7 += System.nanoTime() - startTime;

            copy = new ArrayList<>(arr);
            startTime = System.nanoTime();
            Sort.heapSort(copy);
            estimatedTime8 += System.nanoTime() - startTime;

            copy = new ArrayList<>(arr);
            startTime = System.nanoTime();
            Collections.sort(copy);
            estimatedTime9 += System.nanoTime() - startTime;
        }

        try {
            FileWriter myWriter = new FileWriter("ArrayList.txt");
            myWriter.write((double) estimatedTime0 / repNr + "\n");
            myWriter.write((double) estimatedTime1 / repNr + "\n");
            myWriter.write((double) estimatedTime2 / repNr + "\n");
            myWriter.write((double) estimatedTime3 / repNr + "\n");
            myWriter.write((double) estimatedTime4 / repNr + "\n");
            myWriter.write((double) estimatedTime5 / repNr + "\n");
            myWriter.write((double) estimatedTime6 / repNr + "\n");
            myWriter.write((double) estimatedTime7 / repNr + "\n");
            myWriter.write((double) estimatedTime8 / repNr + "\n");
            myWriter.write((double) estimatedTime9 / repNr + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static void testTime(int arr[]) {
        int copy[];
        long startTime;
        long estimatedTime0 = 0, estimatedTime1 = 0, estimatedTime2 = 0,
                estimatedTime3 = 0, estimatedTime4 = 0, estimatedTime5 = 0,
                estimatedTime6 = 0, estimatedTime7 = 0, estimatedTime8 = 0,
                estimatedTime9 = 0;
        for (int i = 0; i < repNr; i++) {
            copy = arr.clone();
            startTime = System.nanoTime();
            Sort.bubbleSort(copy);
            estimatedTime0 += System.nanoTime() - startTime;

            copy = arr.clone();
            startTime = System.nanoTime();
            Sort.insertionSort(copy);
            estimatedTime1 += System.nanoTime() - startTime;

            copy = arr.clone();
            startTime = System.nanoTime();
            Sort.selectionSort(copy);
            estimatedTime2 += System.nanoTime() - startTime;

            copy = arr.clone();
            startTime = System.nanoTime();
            Sort.quickSortRec(copy);
            estimatedTime3 += System.nanoTime() - startTime;

            copy = arr.clone();
            startTime = System.nanoTime();
            Sort.quickSortIter(copy);
            estimatedTime4 += System.nanoTime() - startTime;

            copy = arr.clone();
            startTime = System.nanoTime();
            Sort.topDownMergeSort(copy);
            estimatedTime5 += System.nanoTime() - startTime;

            copy = arr.clone();
            startTime = System.nanoTime();
            Sort.bottomUpMergeSort(copy);
            estimatedTime6 += System.nanoTime() - startTime;

            copy = arr.clone();
            startTime = System.nanoTime();
            Sort.shellSort(copy);
            estimatedTime7 += System.nanoTime() - startTime;

            copy = arr.clone();
            startTime = System.nanoTime();
            Sort.heapSort(copy);
            estimatedTime8 += System.nanoTime() - startTime;

            copy = arr.clone();
            startTime = System.nanoTime();
            Arrays.sort(copy);
            estimatedTime9 += System.nanoTime() - startTime;
        }
        try {
            FileWriter myWriter = new FileWriter("JavaArray.txt");
            myWriter.write((double) estimatedTime0 / repNr + "\n");
            myWriter.write((double) estimatedTime1 / repNr + "\n");
            myWriter.write((double) estimatedTime2 / repNr + "\n");
            myWriter.write((double) estimatedTime3 / repNr + "\n");
            myWriter.write((double) estimatedTime4 / repNr + "\n");
            myWriter.write((double) estimatedTime5 / repNr + "\n");
            myWriter.write((double) estimatedTime6 / repNr + "\n");
            myWriter.write((double) estimatedTime7 / repNr + "\n");
            myWriter.write((double) estimatedTime8 / repNr + "\n");
            myWriter.write((double) estimatedTime9 / repNr + "\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static ArrayList<Integer> readArrList(int n, String filename) throws IOException {
        ArrayList<Integer> arr = new ArrayList<>();
        File fil = new File(filename);
        FileReader inputFil = new FileReader(fil);
        BufferedReader in = new BufferedReader(inputFil);
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(in.readLine()));
        }
        return arr;
    }

    static int[] readArr(int n, String filename) throws IOException {
        int[] arr = new int[n];
        File fil = new File(filename);
        FileReader inputFil = new FileReader(fil);
        BufferedReader in = new BufferedReader(inputFil);
        for (int i = 0; i < n; i++) {
            arr[i] = (Integer.parseInt(in.readLine()));
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> arr = readArrList(10000, "plik");
        testTime(arr);
        int[] arrr = readArr(10000, "plik");
        testTime(arrr);
    }
}