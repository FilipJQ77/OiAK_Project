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


static int repNr = 10;

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
    long estimatedTime0 = 0,
        estimatedTime1 = 0,
        estimatedTime2 = 0,
        estimatedTime3 = 0,
        estimatedTime4 = 0,
        estimatedTime5 = 0,
        estimatedTime6 = 0,
        estimatedTime7 = 0,
        estimatedTime8 = 0,
        estimatedTime9 = 0;

    for (int i = 0; i < repNr; i++) {

        start = std::chrono::high_resolution_clock::now();
        Sort::bubbleSort(copy);
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime0 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

        copy = arr;
        start = std::chrono::high_resolution_clock::now();
        Sort::insertionSort(copy);
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime1 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

        copy = arr;
        start = std::chrono::high_resolution_clock::now();
        Sort::selectionSort(copy);
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime2 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

        copy = arr;
        start = std::chrono::high_resolution_clock::now();
        Sort::quickSortRec(copy);
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime3 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

        copy = arr;
        start = std::chrono::high_resolution_clock::now();
        Sort::quickSortIter(copy);
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime4 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

        copy = arr;
        start = std::chrono::high_resolution_clock::now();
        Sort::topDownMergeSort(copy);
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime5 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

        copy = arr;
        start = std::chrono::high_resolution_clock::now();
        Sort::bottomUpMergeSort(copy);
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime6 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

        copy = arr;
        start = std::chrono::high_resolution_clock::now();
        Sort::shellSort(copy);
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime7 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

        copy = arr;
        start = std::chrono::high_resolution_clock::now();
        Sort::heapSort(copy);
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime8 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

        copy = arr;
        start = std::chrono::high_resolution_clock::now();
        sort(copy.begin(), copy.end());
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime9 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    }
    
    ofstream myfile;
    myfile.open("Vector.txt");
    myfile << estimatedTime0 / repNr << endl;
    myfile << estimatedTime1 / repNr << endl;
    myfile << estimatedTime3 / repNr << endl;
    myfile << estimatedTime4 / repNr << endl;
    myfile << estimatedTime5 / repNr << endl;
    myfile << estimatedTime6 / repNr << endl;
    myfile << estimatedTime7 / repNr << endl;
    myfile << estimatedTime8 / repNr << endl;
    myfile << estimatedTime9 / repNr << endl;
    myfile.close();
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
    long estimatedTime0 = 0,
        estimatedTime1 = 0,
        estimatedTime2 = 0,
        estimatedTime3 = 0,
        estimatedTime4 = 0,
        estimatedTime5 = 0,
        estimatedTime6 = 0,
        estimatedTime7 = 0,
        estimatedTime8 = 0,
        estimatedTime9 = 0;

    for (int i = 0; i < repNr; i++) {
        start = std::chrono::high_resolution_clock::now();
        Sort::bubbleSort(copy, n);
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime0 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

        copyArray(copy, arr, n);
        start = std::chrono::high_resolution_clock::now();
        Sort::insertionSort(copy, n);
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime1 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

        copyArray(copy, arr, n);
        start = std::chrono::high_resolution_clock::now();
        Sort::selectionSort(copy, n);
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime2 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

        copyArray(copy, arr, n);
        start = std::chrono::high_resolution_clock::now();
        Sort::quickSortRec(copy, n);
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime3 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

        copyArray(copy, arr, n);
        start = std::chrono::high_resolution_clock::now();
        Sort::quickSortIter(copy, n);
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime4 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

        copyArray(copy, arr, n);
        start = std::chrono::high_resolution_clock::now();
        Sort::topDownMergeSort(copy, n);
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime5 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

        copyArray(copy, arr, n);
        start = std::chrono::high_resolution_clock::now();
        Sort::bottomUpMergeSort(copy, n);
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime6 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

        copyArray(copy, arr, n);
        start = std::chrono::high_resolution_clock::now();
        Sort::shellSort(copy, n);
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime7 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

        copyArray(copy, arr, n);
        start = std::chrono::high_resolution_clock::now();
        Sort::heapSort(copy, n);
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime8 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();

        copyArray(copy, arr, n);
        start = std::chrono::high_resolution_clock::now();
        sort(arr, arr + n);
        finish = std::chrono::high_resolution_clock::now();
        estimatedTime9 += std::chrono::duration_cast<std::chrono::nanoseconds>(finish - start).count();
    }

    ofstream myfile;
    myfile.open("CppArray.txt");
    myfile << estimatedTime0 / repNr << endl;
    myfile << estimatedTime1 / repNr << endl;
    myfile << estimatedTime3 / repNr << endl;
    myfile << estimatedTime4 / repNr << endl;
    myfile << estimatedTime5 / repNr << endl;
    myfile << estimatedTime6 / repNr << endl;
    myfile << estimatedTime7 / repNr << endl;
    myfile << estimatedTime8 / repNr << endl;
    myfile << estimatedTime9 / repNr << endl;
    myfile.close();
}

void testRam(vector<int> arr){

    vector<int> copy(arr);
    
    getchar();
    copy = arr;
    printf("Vector - bubbleSort\n");
    getchar();
    Sort::bubbleSort(copy);

    getchar();
    copy = arr;
    printf("Vector - insertionSort\n");
    getchar();
    Sort::insertionSort(copy);

    getchar();
    copy = arr;
    printf("Vector - selectionSort\n");
    getchar();
    Sort::selectionSort(copy);

    getchar();
    copy = arr;
    printf("Vector - quickSortRec\n");
    getchar();
    Sort::quickSortRec(copy);

    getchar();
    copy = arr;
    printf("Vector - quickSortIter\n");
    getchar();
    Sort::quickSortIter(copy);

    getchar();
    copy = arr;
    printf("Vector - topDownMergeSort\n");
    getchar();
    Sort::topDownMergeSort(copy);
    
    getchar();
    copy = arr;
    printf("Vector - bottomUpMergeSort\n");
    getchar();
    Sort::bottomUpMergeSort(copy);

    getchar();
    copy = arr;
    printf("Vector - shellSort\n");
    getchar();
    Sort::shellSort(copy);

    getchar();
    copy = arr;
    printf("Vector - heapSort\n");
    getchar();
    Sort::heapSort(copy);

    getchar();
    copy = arr;
    printf("Vector - library\n");
    getchar();
    sort(copy.begin(), copy.end());
}

void testRam(int* arr, int n)
{
    int* copy;
    copy = new int[n];
    copyArray(copy, arr, n);

    getchar();
    copyArray(copy, arr, n);
    printf("Array - bubbleSort\n");
    getchar();
    Sort::bubbleSort(copy, n);

    getchar();
    copyArray(copy, arr, n);
    printf("Array - insertionSort\n");
    getchar();
    Sort::insertionSort(copy, n);

    getchar();
    copyArray(copy, arr, n);
    printf("Array - selectionSort\n");
    getchar();
    Sort::selectionSort(copy, n);

    getchar();
    copyArray(copy, arr, n);
    printf("Array - quickSortRec\n");
    getchar();
    Sort::quickSortRec(copy, n);

    getchar();
    copyArray(copy, arr, n);
    printf("Array - quickSortIter\n");
    getchar();
    Sort::quickSortIter(copy, n);

    getchar();
    copyArray(copy, arr, n);
    printf("Array - topDownMergeSort\n");
    getchar();
    Sort::topDownMergeSort(copy, n);

    getchar();
    copyArray(copy, arr, n);
    printf("Array - bottomUpMergeSort\n");
    getchar();
    Sort::bottomUpMergeSort(copy, n);

    getchar();
    copyArray(copy, arr, n);
    printf("Array - shellSort\n");
    getchar();
    Sort::shellSort(copy, n);

    getchar();
    copyArray(copy, arr, n);
    printf("Array - heapSort\n");
    getchar();
    Sort::heapSort(copy, n);

    getchar();
    copyArray(copy, arr, n);
    printf("Array - library\n");
    getchar();
    sort(arr, arr + n);
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
    vector<int> vec = read(10);
    //testTime(vec);
    testRam(vec);

    int n = vec.size();
    int* arr;
    arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = vec[i];
    }
    
   // delete &vec;

    testTime(arr, n);
    testRam(arr, n);
}