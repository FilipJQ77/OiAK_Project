package com.company;

import java.io.*;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.util.*;

public class Main {

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
        long estimatedTime;

        startTime = System.nanoTime();
        Sort.bubbleSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList - bubbleSort = " + estimatedTime);

        copy = new LinkedList<>(arr);
        startTime = System.nanoTime();
        Sort.insertionSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList - insertionSort = " + estimatedTime);

        copy = new LinkedList<>(arr);
        startTime = System.nanoTime();
        Sort.selectionSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList - selectionSort = " + estimatedTime);

        copy = new LinkedList<>(arr);
        startTime = System.nanoTime();
        Sort.quickSortRec(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList - quickSortRecursive = " + estimatedTime);

        copy = new LinkedList<>(arr);
        startTime = System.nanoTime();
        Sort.quickSortIter(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList - quickSortIterative = " + estimatedTime);

        copy = new LinkedList<>(arr);
        startTime = System.nanoTime();
        Sort.topDownMergeSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList - topDownMergeSort = " + estimatedTime);

        copy = new LinkedList<>(arr);
        startTime = System.nanoTime();
        Sort.bottomUpMergeSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList - bottomUpergeSort = " + estimatedTime);

        copy = new LinkedList<>(arr);
        startTime = System.nanoTime();
        Sort.shellSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList - shellSort = " + estimatedTime);

        copy = new LinkedList<>(arr);
        startTime = System.nanoTime();
        Sort.heapSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList - heapSort = " + estimatedTime);

        copy = new LinkedList<>(arr);
        startTime = System.nanoTime();
        Collections.sort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("LinkedList - biblioteka = " + estimatedTime);

    }

    static void testTime (ArrayList<Integer> arr)
    {
        ArrayList<Integer> copy = new ArrayList<>(arr);
        long startTime;
        long estimatedTime;

        startTime = System.nanoTime();
        Sort.bubbleSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("ArrayList - bubbleSort = " + estimatedTime);

        copy = new ArrayList<>(arr);
        startTime = System.nanoTime();
        Sort.insertionSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("ArrayList - insertionSort = " + estimatedTime);

        copy = new ArrayList<>(arr);
        startTime = System.nanoTime();
        Sort.selectionSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("ArrayList - selectionSort = " + estimatedTime);

        copy = new ArrayList<>(arr);
        startTime = System.nanoTime();
        Sort.quickSortRec(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("ArrayList - quickSortRecursive = " + estimatedTime);

        copy = new ArrayList<>(arr);
        startTime = System.nanoTime();
        Sort.quickSortIter(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("ArrayList - quickSortIterative = " + estimatedTime);

        copy = new ArrayList<>(arr);
        startTime = System.nanoTime();
        Sort.topDownMergeSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("ArrayList - topDownMergeSort = " + estimatedTime);

        copy = new ArrayList<>(arr);
        startTime = System.nanoTime();
        Sort.bottomUpMergeSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("ArrayList - bottomUpergeSort = " + estimatedTime);

        copy = new ArrayList<>(arr);
        startTime = System.nanoTime();
        Sort.shellSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("ArrayList - shellSort = " + estimatedTime);

        copy = new ArrayList<>(arr);
        startTime = System.nanoTime();
        Sort.heapSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("ArrayList - heapSort = " + estimatedTime);

        copy = new ArrayList<>(arr);
        startTime = System.nanoTime();
        Collections.sort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("ArrayList - biblioteka = " + estimatedTime);

    }

    static void testTime (int arr[])
    {
        int copy[] = arr.clone();
        long startTime;
        long estimatedTime;

        startTime = System.nanoTime();
        Sort.bubbleSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Array - bubbleSort = " + estimatedTime);

        copy = arr.clone();
        startTime = System.nanoTime();
        Sort.insertionSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Array - insertionSort = " + estimatedTime);

        copy = arr.clone();
        startTime = System.nanoTime();
        Sort.selectionSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Array - selectionSort = " + estimatedTime);

        copy = arr.clone();
        startTime = System.nanoTime();
        Sort.quickSortRec(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Array - quickSortRecursive = " + estimatedTime);

        copy = arr.clone();
        startTime = System.nanoTime();
        Sort.quickSortIter(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Array - quickSortIterative = " + estimatedTime);

        copy = arr.clone();
        startTime = System.nanoTime();
        Sort.topDownMergeSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Array - topDownMergeSort = " + estimatedTime);

        copy = arr.clone();
        startTime = System.nanoTime();
        Sort.bottomUpMergeSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Array - bottomUpergeSort = " + estimatedTime);

        copy = arr.clone();
        startTime = System.nanoTime();
        Sort.shellSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Array - shellSort = " + estimatedTime);

        copy = arr.clone();
        startTime = System.nanoTime();
        Sort.heapSort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Array - heapSort = " + estimatedTime);

        copy = arr.clone();
        startTime = System.nanoTime();
        Arrays.sort(copy);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Array - biblioteka = " + estimatedTime);

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
