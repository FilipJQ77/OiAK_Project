#include "SortHelper.h"
#include <iostream>

vector<int> SortHelper::qsSort(vector<int>& arr, int low, int high)
{
    if (low < high) {
        int pivot = qsPartition(arr, low, high);
        qsSort(arr, low, pivot - 1);
        qsSort(arr, pivot + 1, high);
    }
    return arr;
}

int SortHelper::qsPartition(vector<int>& arr, int low, int high)
{
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (arr[j] <= pivot) {
            i += 1;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    i += 1;
    int temp = arr[i];
    arr[i] = arr[high];
    arr[high] = temp;
    return i;
}

static void topDownMerge(vector<int>& arr, int iBegin, int iMiddle, int iEnd, vector<int>& working_arr)
{
    
    int i = iBegin;
    int j = iMiddle;
    for (int k = iBegin; k < iEnd; k++) {
        if (i < iMiddle && (j >= iEnd || arr[i] <= arr[j])) {
            working_arr[k] = arr[i];
            i += 1;
        }
        else {
            working_arr[k] = arr[j];
            j += 1;
        }
    }
}

void SortHelper::topDownSplitMerge(vector<int>& working_arr, int iBegin, int iEnd, vector<int>& arr)
{
    if (iEnd - iBegin < 2)
        return;
    int iMiddle = (iEnd + iBegin) / 2;
    topDownSplitMerge(arr, iBegin, iMiddle, working_arr);
    topDownSplitMerge(arr, iMiddle, iEnd, working_arr);
    topDownMerge(working_arr, iBegin, iMiddle, iEnd, arr);
}

void SortHelper::bottomUpMerge(vector<int>& arr, int l, int m, int r)
{
    int i, j, k;
    int n1 = m - l + 1, n2 = r - m;

    int* L;
    L = new int[n1];
    int* R;
    R = new int[n2];

    for (i = 0; i < n1; i++)
        L[i] = arr[l + i];
    for (j = 0; j < n2; j++)
        R[j] = arr[m + 1 + j];
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

void SortHelper::heapify(vector<int>& arr, int n, int i)
{
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l<n && arr[l] > arr[largest])
        largest = l;
    if (r < n && arr[r] > arr[largest])
        largest = r;
    if (largest != i) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
        heapify(arr, n, largest);
    }
}


int* SortHelper::qsSort(int* arr, int low, int high)
{
    if (low < high) {
        int pivot = qsPartition(arr, low, high);
        qsSort(arr, low, pivot - 1);
        qsSort(arr, pivot + 1, high);
    }
    return arr;
}

int SortHelper::qsPartition(int* arr, int low, int high)
{
    int pivot = arr[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
        if (arr[j] <= pivot) {
            i += 1;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    i += 1;
    int temp = arr[i];
    arr[i] = arr[high];
    arr[high] = temp;
    return i;
}

static void topDownMerge(int* arr, int iBegin, int iMiddle, int iEnd, int* working_arr)
{
    int i = iBegin;
    int j = iMiddle;
    for (int k = iBegin; k < iEnd; k++) {
        if (i < iMiddle && (j >= iEnd || arr[i] <= arr[j])) {
            working_arr[k] = arr[i];
            i += 1;
        }
        else {
            working_arr[k] = arr[j];
            j += 1;
        }
    }
}

void SortHelper::topDownSplitMerge(int* working_arr, int iBegin, int iEnd, int* arr)
{
    if (iEnd - iBegin < 2)
        return;
    int iMiddle = (iEnd + iBegin) / 2;
    topDownSplitMerge(arr, iBegin, iMiddle, working_arr);
    topDownSplitMerge(arr, iMiddle, iEnd, working_arr);
    topDownMerge(working_arr, iBegin, iMiddle, iEnd, arr);
}

void SortHelper::bottomUpMerge(int* arr, int l, int m, int r)
{
    int i, j, k;
    int n1 = m - l + 1, n2 = r - m;

    int* L;
    L = new int[n1];
    int* R;
    R = new int[n2];

    for (i = 0; i < n1; i++)
        L[i] = arr[l + i];
    for (j = 0; j < n2; j++)
        R[j] = arr[m + 1 + j];
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

void SortHelper::heapify(int* arr, int n, int i)
{
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l<n && arr[l] > arr[largest])
        largest = l;
    if (r < n && arr[r] > arr[largest])
        largest = r;
    if (largest != i) {
        int temp = arr[i];
        arr[i] = arr[largest];
        arr[largest] = temp;
        heapify(arr, n, largest);
    }
}
