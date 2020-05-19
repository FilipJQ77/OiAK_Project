#pragma once
#include <vector>
#include "SortHelper.h"
using std::vector;

class Sort
{
public:
	static void bubbleSort(vector<int> &arr);
	static void insertionSort(vector<int> &arr);
	static void selectionSort(vector<int> &arr);
	static void quickSortRec(vector<int> &arr);
	static void quickSortIter(vector<int> &arr);
	static void topDownMergeSort(vector<int>& arr);
	static void bottomUpMergeSort(vector<int>& arr);
	static void shellSort(vector<int>& arr);
	static void heapSort(vector<int>& arr);

	static void bubbleSort(int *arr, int n);
	static void insertionSort(int* arr, int n);
	static void selectionSort(int* arr, int n);
	static void quickSortRec(int* arr, int n);
	static void quickSortIter(int* arr, int n);
	static void topDownMergeSort(int* arr, int n);
	static void bottomUpMergeSort(int* arr, int n);
	static void shellSort(int* arr, int n);
	static void heapSort(int* arr, int n);
}; 

