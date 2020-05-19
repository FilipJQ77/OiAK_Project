// Sortowanie.cpp : Ten plik zawiera funkcję „main”. W nim rozpoczyna się i kończy wykonywanie programu.
//

#include <iostream>
#include <vector>
#include <fstream>
#include <chrono>
#include "Sort.h"
#include <algorithm>
using std::vector;

using namespace std;

void printArray(vector<int> arr)
{
    for (int n : arr) {
        cout << n << " ";
    }
    cout << "\n";
}

void printArray(int* arr, int n)
{
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
}

void isOk(vector<int> arr)
{
    for (int i = 0; i < (int)arr.size() - 1; i++) {
        if (arr[i] > arr[i + 1]) {
            cout << "Cos nie pyklo\n";
            break;
        }
    }
}

void isOk(int* arr, int n)
{
    for (int i = 0; i < n - 1; i++) {
        if (arr[i] > arr[i + 1]) {
            cout << "Cos nie pyklo\n";
            break;
        }
    }
}

void testTime(vector<int> arr)
{
    vector<int> copy(arr);
    auto start = std::chrono::high_resolution_clock::now();

    auto finish = std::chrono::high_resolution_clock::now();
    auto estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

    start = std::chrono::high_resolution_clock::now();
    Sort::bubbleSort(copy);
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Vector - bubbleSort = " << estimatedTime << endl;

    copy = arr;
    start = std::chrono::high_resolution_clock::now();
    Sort::insertionSort(copy);
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Vector - insertionSort = " << estimatedTime << endl;

    copy = arr;
    start = std::chrono::high_resolution_clock::now();
    Sort::selectionSort(copy);
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Vector - selectionSort = " << estimatedTime << endl;

    copy = arr;
    start = std::chrono::high_resolution_clock::now();
    Sort::quickSortRec(copy);
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Vector - quickSortRecursive = " << estimatedTime << endl;

    copy = arr;
    start = std::chrono::high_resolution_clock::now();
    Sort::quickSortIter(copy);
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Vector - quickSortIterative = " << estimatedTime << endl;

    copy = arr;
    start = std::chrono::high_resolution_clock::now();
    Sort::topDownMergeSort(copy);
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Vector - topDownMergeSort = " << estimatedTime << endl;

    copy = arr;
    start = std::chrono::high_resolution_clock::now();
    Sort::bottomUpMergeSort(copy);
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Vector - bottomUpMergeSort = " << estimatedTime << endl;

    copy = arr;
    start = std::chrono::high_resolution_clock::now();
    Sort::shellSort(copy);
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Vector - shellSort = " << estimatedTime << endl;

    copy = arr;
    start = std::chrono::high_resolution_clock::now();
    Sort::heapSort(copy);
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Vector - heapSort = " << estimatedTime << endl;

    copy = arr;
    start = std::chrono::high_resolution_clock::now();
    sort(copy.begin(), copy.end());
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Vector - biblioteka = " << estimatedTime << endl;
}

void copyArray(int* copy, int *oryginal, int n)
{
    for (int i = 0; i < n; i++) {
        copy[i] = oryginal[i];
    }
}

void testTime(int* arr, int n)
{
    int* copy;
    copy = new int[n];
    copyArray(copy, arr, n);
    auto start = std::chrono::high_resolution_clock::now();

    auto finish = std::chrono::high_resolution_clock::now();
    auto estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

    start = std::chrono::high_resolution_clock::now();
    Sort::bubbleSort(copy, n);
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Array - bubbleSort = " << estimatedTime << endl;

    copyArray(copy, arr, n);
    start = std::chrono::high_resolution_clock::now();
    Sort::insertionSort(copy, n);
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Array - insertionSort = " << estimatedTime << endl;

    copyArray(copy, arr, n);
    start = std::chrono::high_resolution_clock::now();
    Sort::selectionSort(copy, n);
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Array - selectionSort = " << estimatedTime << endl;

    copyArray(copy, arr, n);
    start = std::chrono::high_resolution_clock::now();
    Sort::quickSortRec(copy, n);
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Array - quickSortRecursive = " << estimatedTime << endl;

    copyArray(copy, arr, n);
    start = std::chrono::high_resolution_clock::now();
    Sort::quickSortIter(copy, n);
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Array - quickSortIterative = " << estimatedTime << endl;

    copyArray(copy, arr, n);
    start = std::chrono::high_resolution_clock::now();
    Sort::topDownMergeSort(copy, n);
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Array - topDownMergeSort = " << estimatedTime << endl;

    copyArray(copy, arr, n);
    start = std::chrono::high_resolution_clock::now();
    Sort::bottomUpMergeSort(copy, n);
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Array - bottomUpMergeSort = " << estimatedTime << endl;

    copyArray(copy, arr, n);
    start = std::chrono::high_resolution_clock::now();
    Sort::shellSort(copy, n);
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Array - shellSort = " << estimatedTime << endl;

    copyArray(copy, arr, n);
    start = std::chrono::high_resolution_clock::now();
    Sort::heapSort(copy, n);
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Array - heapSort = " << estimatedTime << endl;

    copyArray(copy, arr, n);
    start = std::chrono::high_resolution_clock::now();
    sort(arr, arr + n);
    finish = std::chrono::high_resolution_clock::now();
    estimatedTime = std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    cout << "Array - biblioteka = " << estimatedTime << endl;
}

vector<int> read(int n) {
    vector<int> arr;
    int a;
    ifstream file;
    file.open("liczby.txt");
    for (int i = 0; i < n; i++) {
        file >> a;
        arr.push_back(a);
    }
    file.close();
    return arr;
}

int main()
{
    vector<int> arr1 = read(10);
    int n = arr1.size();
    int* arr;
    arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = arr1[i];
    }

    testTime(arr1);
    testTime(arr, n);

    /* SORTOWANIE WBUDOWANE */
    /*sort(arr1.begin(), arr1.end());  // SORTOWANIE WEKTORA
    printArray(arr1);
    sort(arr, arr + n);              // SORTOWANIE TABLICY
    printArray(arr, n);
    
    printArray(Sort::insertionSort(arr));
    printArray(Sort::selectionSort(arr));
    printArray(Sort::quickSort(arr));
    printArray(arr);
    */
}