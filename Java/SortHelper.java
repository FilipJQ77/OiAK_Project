package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SortHelper {
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

    static void topDownSplitMerge(ArrayList<Integer> working_arr, int iBegin, int iEnd, ArrayList<Integer> arr)
    {
        if(iEnd - iBegin < 2)
            return;
        int iMiddle = (iEnd + iBegin) / 2;
        topDownSplitMerge(arr, iBegin, iMiddle, working_arr);
        topDownSplitMerge(arr, iMiddle, iEnd, working_arr);
        topDownMerge(working_arr, iBegin, iMiddle, iEnd, arr);
    }

    static void topDownMerge (ArrayList<Integer> arr, int iBegin, int iMiddle, int iEnd, ArrayList<Integer> working_arr)
    {
        int i = iBegin;
        int j = iMiddle;
        for (int k=iBegin; k < iEnd; k++){
            if (i < iMiddle && (j >= iEnd || arr.get(i) <= arr.get(j))){
                working_arr.set(k, arr.get(i));
                i += 1;
            } else {
                working_arr.set(k, arr.get(j));
                j += 1;
            }
        }
    }

    static void topDownSplitMerge(int working_arr[], int iBegin, int iEnd, int arr[])
    {
        if(iEnd - iBegin < 2)
            return;
        int iMiddle = (iEnd + iBegin) / 2;
        topDownSplitMerge(arr, iBegin, iMiddle, working_arr);
        topDownSplitMerge(arr, iMiddle, iEnd, working_arr);
        topDownMerge(working_arr, iBegin, iMiddle, iEnd, arr);
    }

    static void topDownMerge (int arr[], int iBegin, int iMiddle, int iEnd, int working_arr[])
    {
        int i = iBegin;
        int j = iMiddle;
        for (int k=iBegin; k < iEnd; k++){
            if (i < iMiddle && (j >= iEnd || arr[i] <= arr[j])){
                working_arr[k] = arr[i];
                i += 1;
            } else {
                working_arr[k] = arr[j];
                j += 1;
            }
        }
    }

    static LinkedList<Integer> topDownMergeSort (LinkedList<Integer> arr)
    {
        if (arr.size() <= 1)
            return arr;
        LinkedList left = new LinkedList();
        LinkedList right = new LinkedList();
        for (int i = 0; i < arr.size(); i++){
            if (i < arr.size()/2) {
                left.add(arr.get(i));
            } else
                right.add(arr.get(i));
        }
        left = topDownMergeSort(left);
        right = topDownMergeSort(right);
        return SortHelper.merge(left,right);
    }

    static LinkedList<Integer> merge (LinkedList <Integer> left, LinkedList <Integer> right)
    {
        LinkedList <Integer> result = new LinkedList<>();
        while(!left.isEmpty() && !right.isEmpty()){
            if (left.getFirst() <= right.getFirst()){
                result.add(left.getFirst());
                left.removeFirst();
            } else{
                result.add(right.getFirst());
                right.removeFirst();
            }
        }
        while (!left.isEmpty()){
            result.add(left.getFirst());
            left.removeFirst();
        }
        while (!right.isEmpty()){
            result.add(right.getFirst());
            right.removeFirst();
        }
        return result;
    }

    static void bottomUpMerge(int arr[], int l, int m, int r)
    {
        int i, j, k;
        int n1 = m - l + 1, n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];
        for (i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (j = 0; j < n2; j++)
            R[j] = arr[m + 1+ j];
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void bottomUpMerge(List<Integer> arr, int l, int m, int r)
    {
        int i, j, k;
        int n1 = m - l + 1, n2 = r - m;

        ArrayList<Integer> L = new ArrayList<>();
        ArrayList<Integer> R = new ArrayList<>();
        for (i = 0; i < n1; i++)
            L.add(i, arr.get(l + i));
        for (j = 0; j < n2; j++)
            R.add(j, arr.get(m + 1 + j));
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2)
        {
            if (L.get(i) <= R.get(j))
            {
                arr.set(k, L.get(i));
                i++;
            }
            else
            {
                arr.set(k, R.get(j));
                j++;
            }
            k++;
        }
        while (i < n1)
        {
            arr.set(k, L.get(i));
            i++;
            k++;
        }
        while (j < n2)
        {
            arr.set(k, R.get(j));
            j++;
            k++;
        }
    }

    static void heapify(int arr[], int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l<n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }
    }

    static void heapify(List<Integer> arr, int n, int i)
    {
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l<n && arr.get(l) > arr.get(largest))
            largest = l;
        if (r < n && arr.get(r) > arr.get(largest))
            largest = r;
        if (largest != i){
            int temp = arr.get(i);
            arr.set(i, arr.get(largest));
            arr.set(largest, temp);
            heapify(arr, n, largest);
        }
    }
}
