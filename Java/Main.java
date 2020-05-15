package com.company;

import java.net.Inet4Address;
import java.util.*;

public class Main {

    static ArrayList<Integer> generateData(int amount){
        ArrayList<Integer> arr = new ArrayList<>();
        Random generator = new Random();
        for (int i = 0; i < amount; i++){
            arr.add(generator.nextInt(1000));
        }
        return arr;
    }

    static void czyok (List<Integer> sorted, List<Integer> arr)
    {
        System.out.print("u");
        for (int i = 0; i < sorted.size(); i++){
            if (!sorted.get(i).equals(arr.get(i))){
                System.out.println("guwno");
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

    public static void main(String[] args)
    {
        ArrayList<Integer> arr = generateData(1000);
        LinkedList<Integer> copy = new LinkedList<>(arr);
        LinkedList<Integer> sorted = new LinkedList<>(arr);
        Collections.sort(sorted);

        Sort.bubbleSort(copy);
        czyok(sorted, copy);
        copy = new LinkedList<>(arr);

        Sort.insertionSort(copy);
        czyok(sorted, copy);
        copy = new LinkedList<>(arr);

        Sort.selectionSort(copy);
        czyok(sorted, copy);
        copy = new LinkedList<>(arr);

        Sort.quickSortRec(copy);
        czyok(sorted, copy);
        copy = new LinkedList<>(arr);

        Sort.quickSortIter(copy);
        czyok(sorted, copy);
        copy = new LinkedList<>(arr);

        Sort.topDownMergeSort(copy);
        czyok(sorted, copy);
        copy = new LinkedList<>(arr);

        Sort.bottomUpMergeSort(copy);
        czyok(sorted, copy);
        copy = new LinkedList<>(arr);

        Sort.shellSort(copy);
        czyok(sorted, copy);
        copy = new LinkedList<>(arr);

        Sort.heapSort(copy);
        czyok(sorted, copy);
        copy = new LinkedList<>(arr);
            // SORTOWANIE Z BIBLIOTEK
//        Arrays.sort(arr); // DO TABLICY
//        printArray(arr);
//        Collections.sort(lista2); // DO LIST
//        printList(lista2);
    }
}
