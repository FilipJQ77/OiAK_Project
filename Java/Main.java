package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;

public class Main {
    static int repNr = 10;

    static void isOk (List<Integer> arr)
    {
        for (int i = 0; i < arr.size()-1; i++){
            if (arr.get(i) > arr.get(i+1)){
                System.out.println("Cos nie pyklo");
                break;
            }
        }
    }

    static void isOk (int arr[])
    {
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > arr[i+1]){
                System.out.println("Cos nie pyklo");
                break;
            }
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    static void printList(List<Integer> lista)
    {
        for (int i : lista){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void testTime (LinkedList<Integer> arr)
    {
        LinkedList<Integer> copy = new LinkedList<>(arr);
        long startTime;
        long estimatedTime0 = 0, estimatedTime1 = 0, estimatedTime2 = 0,
                estimatedTime3 = 0, estimatedTime4 = 0, estimatedTime5 = 0,
                estimatedTime6 = 0, estimatedTime7 = 0, estimatedTime8 = 0,
                estimatedTime9 = 0;

        for (int i = 0; i < repNr; i++) {

            copy = new LinkedList<>(arr);
            startTime = System.nanoTime();
            Sort.bubbleSort(copy);
            estimatedTime0 += System.nanoTime() - startTime;

            copy = new LinkedList<>(arr);
            startTime = System.nanoTime();
            Sort.insertionSort(copy);
            estimatedTime1 += System.nanoTime() - startTime;

            copy = new LinkedList<>(arr);
            startTime = System.nanoTime();
            Sort.selectionSort(copy);
            estimatedTime2 += System.nanoTime() - startTime;

            copy = new LinkedList<>(arr);
            startTime = System.nanoTime();
            Sort.quickSortRec(copy);
            estimatedTime3 += System.nanoTime() - startTime;

            copy = new LinkedList<>(arr);
            startTime = System.nanoTime();
            Sort.quickSortIter(copy);
            estimatedTime4 += System.nanoTime() - startTime;

            copy = new LinkedList<>(arr);
            startTime = System.nanoTime();
            Sort.topDownMergeSort(copy);
            estimatedTime5 += System.nanoTime() - startTime;

            copy = new LinkedList<>(arr);
            startTime = System.nanoTime();
            Sort.bottomUpMergeSort(copy);
            estimatedTime6 += System.nanoTime() - startTime;

            copy = new LinkedList<>(arr);
            startTime = System.nanoTime();
            Sort.shellSort(copy);
            estimatedTime7 += System.nanoTime() - startTime;

            copy = new LinkedList<>(arr);
            startTime = System.nanoTime();
            Sort.heapSort(copy);
            estimatedTime8 += System.nanoTime() - startTime;

            copy = new LinkedList<>(arr);
            startTime = System.nanoTime();
            Collections.sort(copy);
            estimatedTime9 += System.nanoTime() - startTime;
        }

        try {
            FileWriter myWriter = new FileWriter("LinkedList.txt");
            myWriter.write("LinkedList - bubbleSort = " + estimatedTime0/repNr + "us");
            myWriter.write("\nLinkedList - insertionSort = " + estimatedTime1/repNr + "us");
            myWriter.write("\nLinkedList - selectionSort = " + estimatedTime2/repNr + "us");
            myWriter.write("\nLinkedList - quickSortRecursive = " + estimatedTime3/repNr + "us");
            myWriter.write("\nLinkedList - quickSortIterative = " + estimatedTime4/repNr + "us");
            myWriter.write("\nLinkedList - topDownMergeSort = " + estimatedTime5/repNr + "us");
            myWriter.write("\nLinkedList - bottomUpMergeSort = " + estimatedTime6/repNr + "us");
            myWriter.write("\nLinkedList - shellSort = " + estimatedTime7/repNr + "us");
            myWriter.write("\nLinkedList - heapSort = " + estimatedTime8/repNr + "us");
            myWriter.write("\nLinkedList - librarySort = " + estimatedTime9/repNr + "us");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static void testTime (ArrayList<Integer> arr)
    {
        ArrayList<Integer> copy = new ArrayList<>(arr);
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
            myWriter.write("ArrayList - bubbleSort = " + estimatedTime0/repNr + "us");
            myWriter.write("\nArrayList - insertionSort = " + estimatedTime1/repNr + "us");
            myWriter.write("\nArrayList - selectionSort = " + estimatedTime2/repNr + "us");
            myWriter.write("\nArrayList - quickSortRecursive = " + estimatedTime3/repNr + "us");
            myWriter.write("\nArrayList - quickSortIterative = " + estimatedTime4/repNr + "us");
            myWriter.write("\nArrayList - topDownMergeSort = " + estimatedTime5/repNr + "us");
            myWriter.write("\nArrayList - bottomUpMergeSort = " + estimatedTime6/repNr + "us");
            myWriter.write("\nArrayList - shellSort = " + estimatedTime7/repNr + "us");
            myWriter.write("\nArrayList - heapSort = " + estimatedTime8/repNr + "us");
            myWriter.write("\nArrayList - librarySort = " + estimatedTime9/repNr + "us");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static void testTime (int arr[])
    {
        int copy[] = arr.clone();
        long startTime;
        long estimatedTime0 = 0, estimatedTime1 = 0, estimatedTime2 = 0,
                estimatedTime3 = 0, estimatedTime4 = 0, estimatedTime5 = 0,
                estimatedTime6 = 0, estimatedTime7 = 0, estimatedTime8 = 0,
                estimatedTime9 = 0;
        for (int i = 0; i < repNr; i++) {
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
            myWriter.write("Array - bubbleSort = " + estimatedTime0/repNr + "us");
            myWriter.write("\nArray - insertionSort = " + estimatedTime1/repNr + "us");
            myWriter.write("\nArray - selectionSort = " + estimatedTime2/repNr + "us");
            myWriter.write("\nArray - quickSortRecursive = " + estimatedTime3/repNr + "us");
            myWriter.write("\nArray - quickSortIterative = " + estimatedTime4/repNr + "us");
            myWriter.write("\nArray - topDownMergeSort = " + estimatedTime5/repNr + "us");
            myWriter.write("\nArray - bottomUpMergeSort = " + estimatedTime6/repNr + "us");
            myWriter.write("\nArray - shellSort = " + estimatedTime7/repNr + "us");
            myWriter.write("\nArray - heapSort = " + estimatedTime8/repNr + "us");
            myWriter.write("\nArray - librarySort = " + estimatedTime9/repNr + "us");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    static void testRam (LinkedList<Integer> list) throws IOException {

        System.gc();
        LinkedList<Integer> copy = new LinkedList<>(list);
        System.out.println("LinkedList - bubbleSort");
        System.in.read();
        Sort.bubbleSort(copy);

        System.in.read();
        System.gc();
        copy = new LinkedList<>(list);
        System.out.println("LinkedList - insertionSort");
        System.in.read();
        Sort.insertionSort(copy);

        System.in.read();
        System.gc();
        copy = new LinkedList<>(list);
        System.out.println("LinkedList - selectionSort");
        System.in.read();
        Sort.selectionSort(copy);

        System.in.read();
        System.gc();
        copy = new LinkedList<>(list);
        System.out.println("LinkedList - quickSortRec");
        System.in.read();
        Sort.quickSortRec(copy);

        System.in.read();
        System.gc();
        copy = new LinkedList<>(list);
        System.out.println("LinkedList - quickSortIter");
        System.in.read();
        Sort.quickSortIter(copy);

        System.in.read();
        System.gc();
        copy = new LinkedList<>(list);
        System.out.println("LinkedList - topDownMergeSort");
        System.in.read();
        Sort.topDownMergeSort(copy);

        System.in.read();
        System.gc();
        copy = new LinkedList<>(list);
        System.out.println("LinkedList - bottomUpMergeSort");
        System.in.read();
        Sort.bottomUpMergeSort(copy);

        System.in.read();
        System.gc();
        copy = new LinkedList<>(list);
        System.out.println("LinkedList - shellSort");
        System.in.read();
        Sort.shellSort(copy);

        System.in.read();
        System.gc();
        copy = new LinkedList<>(list);
        System.out.println("LinkedList - heapSort");
        System.in.read();
        Sort.heapSort(copy);

        System.in.read();
        System.gc();
        copy = new LinkedList<>(list);
        System.out.println("LinkedList - library");
        System.in.read();
        Collections.sort(copy);
    }

    static void testRam (ArrayList<Integer> list) throws IOException {

        System.gc();
        ArrayList<Integer> copy = new ArrayList<>(list);
        System.out.println("ArrayList - bubbleSort");
        System.in.read();
        Sort.bubbleSort(copy);

        System.in.read();
        copy = new ArrayList<>(list);
        System.out.println("ArrayList - insertionSort");
        System.in.read();
        Sort.insertionSort(copy);

        System.in.read();
        System.gc();
        copy = new ArrayList<>(list);
        System.out.println("ArrayList - selectionSort");
        System.in.read();
        Sort.selectionSort(copy);

        System.in.read();
        System.gc();
        copy = new ArrayList<>(list);
        System.out.println("ArrayList - quickSortRec");
        System.in.read();
        Sort.quickSortRec(copy);

        System.in.read();
        System.gc();
        copy = new ArrayList<>(list);
        System.out.println("ArrayList - quickSortIter");
        System.in.read();
        Sort.quickSortIter(copy);

        System.in.read();
        System.gc();
        copy = new ArrayList<>(list);
        System.out.println("ArrayList - topDownMergeSort");
        System.in.read();
        Sort.topDownMergeSort(copy);

        System.in.read();
        System.gc();
        copy = new ArrayList<>(list);
        System.out.println("ArrayList - bottomUpMergeSort");
        System.in.read();
        Sort.bottomUpMergeSort(copy);

        System.in.read();
        System.gc();
        copy = new ArrayList<>(list);
        System.out.println("ArrayList - shellSort");
        System.in.read();
        Sort.shellSort(copy);

        System.in.read();
        System.gc();
        copy = new ArrayList<>(list);
        System.out.println("ArrayList - heapSort");
        System.in.read();
        Sort.heapSort(copy);

        System.in.read();
        System.gc();
        copy = new ArrayList<>(list);
        System.out.println("ArrayList - library");
        System.in.read();
        Collections.sort(copy);
    }

    static void testRam (int arr[]) throws IOException {

        System.gc();
        int copy[] = arr.clone();
        System.out.println("Array - bubbleSort");
        System.in.read();
        Sort.bubbleSort(copy);

        System.in.read();
        copy = arr.clone();
        System.out.println("Array - insertionSort");
        System.in.read();
        Sort.insertionSort(copy);

        System.in.read();
        System.gc();
        copy = arr.clone();
        System.out.println("Array - selectionSort");
        System.in.read();
        Sort.selectionSort(copy);

        System.in.read();
        System.gc();
        copy = arr.clone();
        System.out.println("Array - quickSortRec");
        System.in.read();
        Sort.quickSortRec(copy);

        System.in.read();
        System.gc();
        copy = arr.clone();
        System.out.println("Array - quickSortIter");
        System.in.read();
        Sort.quickSortIter(copy);

        System.in.read();
        System.gc();
        copy = arr.clone();
        System.out.println("Array - topDownMergeSort");
        System.in.read();
        Sort.topDownMergeSort(copy);

        System.in.read();
        System.gc();
        copy = arr.clone();
        System.out.println("Array - bottomUpMergeSort");
        System.in.read();
        Sort.bottomUpMergeSort(copy);

        System.in.read();
        System.gc();
        copy = arr.clone();
        System.out.println("Array - shellSort");
        System.in.read();
        Sort.shellSort(copy);

        System.in.read();
        System.gc();
        copy = arr.clone();
        System.out.println("Array - heapSort");
        System.in.read();
        Sort.heapSort(copy);

        System.in.read();
        System.gc();
        copy = arr.clone();
        System.out.println("Array - library");
        System.in.read();
        Arrays.sort(copy);
    }

    static ArrayList<Integer> read(int n) throws IOException {
        ArrayList<Integer> arr = new ArrayList<>();
        File fil = new File("liczby.txt");
        FileReader inputFil = new FileReader(fil);
        BufferedReader in = new BufferedReader(inputFil);
        for (int i = 0; i < n; i++){
            arr.add(Integer.parseInt(in.readLine()));
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> arr = read(10);
        LinkedList<Integer> copy = new LinkedList<>(arr);

        int array[] = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++){
            array[i] = arr.get(i).intValue();
        }
        testTime(array);
        testTime(arr);
        testTime(copy);
            // SORTOWANIE Z BIBLIOTEK
//        Arrays.sort(arr); // DO TABLICY
//        printArray(arr);
//        Collections.sort(lista2); // DO LIST
//        printList(lista2);
    }
}
