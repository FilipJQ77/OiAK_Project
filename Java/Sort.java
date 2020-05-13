package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sort {

    static List<Integer> bubbleSort(List<Integer> arr)
    {
        int n = arr.size();
        int newn;
        do{
            newn = 0;
            for (int i = 1; i <= n - 1; i++){
                if (arr.get(i-1) > arr.get(i)){
                    int temp = arr.get(i);
                    arr.set(i,arr.get(i-1));
                    arr.set(i-1,temp);
                    newn = i;
                }
            }
            n = newn;
        } while (n > 1);
        return arr;
    }

    static int[] bubbleSort(int arr[])
    {
        int n = arr.length;
        int newn;
        do{
            newn = 0;
            for (int i = 1; i <= n - 1; i++){
                if (arr[i-1] > arr[i]){
                    int temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;
                    newn = i;
                }
            }
            n = newn;
        } while (n > 1);
        return arr;
    }

    static List<Integer> insertionSort(List<Integer> arr)
    {
        int i = 1, j;
        int n = arr.size();
        int x;
        while (i < n){
            x = arr.get(i);
            j = i - 1;
            while (j >= 0 && arr.get(j) > x){
                arr.set(j + 1, arr.get(j));
                j-=1;
            }
            arr.set(j + 1, x);
            i+=1;
        }
        return arr;
    }

    static int[] insertionSort(int arr[])
    {
        int i = 1, j;
        int n = arr.length;
        int x;
        while (i < n){
            x = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > x){
                arr[j+1] = arr[j];
                j-=1;
            }
            arr[j+1] = x;
            i+=1;
        }
        return arr;
    }

    static List<Integer> selectionSort(List<Integer> arr)
    {
        int n = arr.size();
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr.get(j) < arr.get(min_idx))
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            if (min_idx != i) {
                int temp = arr.get(min_idx);
                arr.set(min_idx, arr.get(i));
                arr.set(i, temp);
            }
        }
        return arr;
    }

    static int[] selectionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            if (min_idx != i) {
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    static List<Integer> quickSort(List<Integer> arr)
    {
        return qsSort(arr, 0, arr.size() - 1);
    }

    static List<Integer> qsSort(List<Integer> arr, int low, int high)
    {
        if (low < high){
            int pivot = qsPartition(arr, low, high);
            qsSort(arr, low, pivot - 1);
            qsSort(arr, pivot + 1, high);
        }
        return arr;
    }

    static int qsPartition (List<Integer> arr, int low, int high)
    {
        int pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++){
            if (arr.get(j) <= pivot){
                i+=1;
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        i+=1;
        int temp = arr.get(i);
        arr.set(i, arr.get(high));
        arr.set(high, temp);
        return i;
    }

    static int[] quickSort(int arr[])
    {
        return qsSort(arr, 0, arr.length - 1);
    }

    static int[] qsSort(int arr[], int low, int high)
    {
        if (low < high){
            int pivot = qsPartition(arr, low, high);
            qsSort(arr, low, pivot - 1);
            qsSort(arr, pivot + 1, high);
        }
        return arr;
    }

    static int qsPartition (int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++){
            if (arr[j] <= pivot){
                i+=1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i+=1;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }
}
