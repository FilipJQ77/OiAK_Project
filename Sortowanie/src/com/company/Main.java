package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    static void printList(List<Integer> lista){
        for (int i : lista){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        int arr_oryginal[] = {1,2,3,4,64,25,12,22,11};
        List lista = new LinkedList<Integer>();

        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(64);
        lista.add(25);
        lista.add(12);
        lista.add(22);
        lista.add(11);
        List lista2 = new LinkedList(lista);
        printList(Sort.bubbleSort(lista2));
        printList(lista);

        int arr[] = arr_oryginal.clone();
        printArray(Sort.bubbleSort(arr));
        arr = arr_oryginal.clone();
        printArray(arr);
        printArray(Sort.insertionSort(arr));
        arr = arr_oryginal.clone();
        printArray(arr);
        printArray(Sort.selectionSort(arr));
        arr = arr_oryginal.clone();
        printArray(arr);
        printArray(Sort.quickSort(arr));
        arr = arr_oryginal.clone();
        printArray(arr);
    }
}
