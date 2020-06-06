#include "Sort.h"
#include <iostream>
#include <algorithm>
#include <stack>
using namespace std;

void Sort::bubbleSort(vector<int>& arr)
{
    int n = arr.size();
    int newn;
    do {
        newn = 0;
        for (int i = 1; i <= n - 1; i++) {
            if (arr[i - 1] > arr[i]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                newn = i;
            }
        }
        n = newn;
    } while (n > 1);
}

void Sort::insertionSort(vector<int>& arr)
{
    int i = 1, j;
    int n = arr.size();
    int x;
    while (i < n) {
        x = arr[i];
        j = i - 1;
        while (j >= 0 && arr[j] > x) {
            arr[j + 1] = arr[j];
            j -= 1;
        }
        arr[j + 1] = x;
        i += 1;
    }
}

void Sort::selectionSort(vector<int>& arr)
{
    int n = arr.size();
    for (int i = 0; i < n - 1; i++)
    {
        int min_idx = i;
        for (int j = i + 1; j < n; j++)
            if (arr[j] < arr[min_idx])
                min_idx = j;

        if (min_idx != i) {
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}

void Sort::quickSortRec(vector<int>& arr)
{
    SortHelper::qsSort(arr, 0, arr.size() - 1);
}

void Sort::quickSortIter(vector<int>& arr)
{
    int l = 0;
    int h = arr.size() - 1;

    stack <int> stack;

    stack.push(l);
    stack.push(h);

    while (!stack.empty()) {
        h = stack.top();
        stack.pop();
        l = stack.top();
        stack.pop();

        int p = SortHelper::qsPartition(arr, l, h);
        if (p - 1 > l) {
            stack.push(l);
            stack.push(p - 1);
        }
        if (p + 1 < h) {
            stack.push(p + 1);
            stack.push(h);
        }
    }
}

void Sort::topDownMergeSort(vector<int>& arr)
{
    vector<int> working_arr(arr);
    SortHelper::topDownSplitMerge(working_arr, 0, arr.size(), arr);
}

void Sort::bottomUpMergeSort(vector<int>& arr)
{
    int n = arr.size();
    int curr_size;
    int left_start;
    for (curr_size = 1; curr_size < n; curr_size *= 2) {
        for (left_start = 0; left_start < n; left_start += 2 * curr_size) {
            SortHelper::bottomUpMerge(arr, left_start, min(left_start + curr_size - 1, n - 1), min(left_start + 2 * curr_size - 1, n - 1));
        }
    }
}

void Sort::shellSort(vector<int>& arr)
{
    int n = arr.size();
    int gap = n / 2;
    while (gap > 0)
    {
        for (int i = gap; i < n; i++)
        {
            int temp = arr[i];
            int j = i;
            while (j >= gap && arr[j - gap] > temp)
            {
                arr[j] = arr[j - gap];
                j -= gap;
            }
            arr[j] = temp;
        }
        gap /= 2;
    }
}

void Sort::heapSort(vector<int>& arr)
{
    int n = arr.size();
    for (int i = n / 2 - 1; i >= 0; i--)
        SortHelper::heapify(arr, n, i);
    for (int i = n - 1; i > 0; i--) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        SortHelper::heapify(arr, i, 0);
    }
}


void Sort::bubbleSort(int* arr, int n)
{
    int newn;
    do {
        newn = 0;
        for (int i = 1; i <= n - 1; i++) {
            if (arr[i - 1] > arr[i]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                newn = i;
            }
        }
        n = newn;
    } while (n > 1);
}

void Sort::insertionSort(int* arr, int n)
{
    int i = 1, j;
    int x;
    while (i < n) {
        x = arr[i];
        j = i - 1;
        while (j >= 0 && arr[j] > x) {
            arr[j + 1] = arr[j];
            j -= 1;
        }
        arr[j + 1] = x;
        i += 1;
    }
}

void Sort::selectionSort(int* arr, int n)
{
    for (int i = 0; i < n - 1; i++)
    {
        int min_idx = i;
        for (int j = i + 1; j < n; j++)
            if (arr[j] < arr[min_idx])
                min_idx = j;

        if (min_idx != i) {
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}

void Sort::quickSortRec(int* arr, int n)
{
    SortHelper::qsSort(arr, 0, n - 1);
}

void Sort::quickSortIter(int* arr, int n)
{
    int l = 0;
    int h = n - 1;

    stack <int> stack;
    stack.push(l);
    stack.push(h);

    while (!stack.empty()) {
        h = stack.top();
        stack.pop();
        l = stack.top();
        stack.pop();

        int p = SortHelper::qsPartition(arr, l, h);

        if (p - 1 > l) {
            stack.push(l);
            stack.push(p - 1);
        }

        if (p + 1 < h) {
            stack.push(p + 1);
            stack.push(h);
        }
    }
}

void Sort::topDownMergeSort(int* arr, int n)
{
    int* working_arr;
    working_arr = new int[n];
    for (int i = 0; i < n; i++) {
        working_arr[i] = arr[i];
    }
    SortHelper::topDownSplitMerge(working_arr, 0, n, arr);
}

void Sort::bottomUpMergeSort(int* arr, int n)
{
    int curr_size;
    int left_start;
    for (curr_size = 1; curr_size < n; curr_size *= 2) {
        for (left_start = 0; left_start < n; left_start += 2 * curr_size) {
            SortHelper::bottomUpMerge(arr, left_start, min(left_start + curr_size - 1, n - 1), min(left_start + 2 * curr_size - 1, n - 1));
        }
    }
}

void Sort::shellSort(int* arr, int n)
{
    int gap = n / 2;
    while (gap > 0)
    {
        for (int i = gap; i < n; i++)
        {
            int temp = arr[i];
            int j = i;
            while (j >= gap && arr[j - gap] > temp)
            {
                arr[j] = arr[j - gap];
                j -= gap;
            }
            arr[j] = temp;
        }
        gap /= 2;
    }
}

void Sort::heapSort(int* arr, int n)
{
    for (int i = n / 2 - 1; i >= 0; i--)
        SortHelper::heapify(arr, n, i);
    for (int i = n - 1; i > 0; i--) {
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        SortHelper::heapify(arr, i, 0);
    }
}