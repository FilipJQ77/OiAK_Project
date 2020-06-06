#include <iostream>
#include <vector>
#include <fstream>
#include <chrono>
#include "Sort.h"
#include <algorithm>

using namespace std;


static int repNr = 10;

void testTime(vector<int> arr)
{
	vector<int> copy(arr);
	auto start = chrono::high_resolution_clock::now();

	auto finish = chrono::high_resolution_clock::now();
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

		start = chrono::high_resolution_clock::now();
		Sort::bubbleSort(copy);
		finish = chrono::high_resolution_clock::now();
		estimatedTime0 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count() / 1000;

		copy = arr;
		start = chrono::high_resolution_clock::now();
		Sort::insertionSort(copy);
		finish = chrono::high_resolution_clock::now();
		estimatedTime1 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count() / 1000;

		copy = arr;
		start = chrono::high_resolution_clock::now();
		Sort::selectionSort(copy);
		finish = chrono::high_resolution_clock::now();
		estimatedTime2 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count() / 1000;

		copy = arr;
		start = chrono::high_resolution_clock::now();
		Sort::quickSortRec(copy);
		finish = chrono::high_resolution_clock::now();
		estimatedTime3 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count() / 1000;

		copy = arr;
		start = chrono::high_resolution_clock::now();
		Sort::quickSortIter(copy);
		finish = chrono::high_resolution_clock::now();
		estimatedTime4 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count() / 1000;

		copy = arr;
		start = chrono::high_resolution_clock::now();
		Sort::topDownMergeSort(copy);
		finish = chrono::high_resolution_clock::now();
		estimatedTime5 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count() / 1000;

		copy = arr;
		start = chrono::high_resolution_clock::now();
		Sort::bottomUpMergeSort(copy);
		finish = chrono::high_resolution_clock::now();
		estimatedTime6 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count() / 1000;

		copy = arr;
		start = chrono::high_resolution_clock::now();
		Sort::shellSort(copy);
		finish = chrono::high_resolution_clock::now();
		estimatedTime7 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count() / 1000;

		copy = arr;
		start = chrono::high_resolution_clock::now();
		Sort::heapSort(copy);
		finish = chrono::high_resolution_clock::now();
		estimatedTime8 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count() / 1000;

		copy = arr;
		start = chrono::high_resolution_clock::now();
		sort(copy.begin(), copy.end());
		finish = chrono::high_resolution_clock::now();
		estimatedTime9 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count() / 1000;
	}

	ofstream myfile;
	myfile.open("Vector.txt");
	myfile << estimatedTime0 / repNr << endl;
	myfile << estimatedTime1 / repNr << endl;
	myfile << estimatedTime2 / repNr << endl;
	myfile << estimatedTime3 / repNr << endl;
	myfile << estimatedTime4 / repNr << endl;
	myfile << estimatedTime5 / repNr << endl;
	myfile << estimatedTime6 / repNr << endl;
	myfile << estimatedTime7 / repNr << endl;
	myfile << estimatedTime8 / repNr << endl;
	myfile << estimatedTime9 / repNr << endl;
	myfile.close();
}

void copyArray(int* copy, int* oryginal, int n)
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
	auto start = chrono::high_resolution_clock::now();

	auto finish = chrono::high_resolution_clock::now();
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
		start = chrono::high_resolution_clock::now();
		Sort::bubbleSort(copy, n);
		finish = chrono::high_resolution_clock::now();
		estimatedTime0 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count()/1000;

		copyArray(copy, arr, n);
		start = chrono::high_resolution_clock::now();
		Sort::insertionSort(copy, n);
		finish = chrono::high_resolution_clock::now();
		estimatedTime1 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count() / 1000;

		copyArray(copy, arr, n);
		start = chrono::high_resolution_clock::now();
		Sort::selectionSort(copy, n);
		finish = chrono::high_resolution_clock::now();
		estimatedTime2 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count() / 1000;

		copyArray(copy, arr, n);
		start = chrono::high_resolution_clock::now();
		Sort::quickSortRec(copy, n);
		finish = chrono::high_resolution_clock::now();
		estimatedTime3 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count() / 1000;

		copyArray(copy, arr, n);
		start = chrono::high_resolution_clock::now();
		Sort::quickSortIter(copy, n);
		finish = chrono::high_resolution_clock::now();
		estimatedTime4 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count() / 1000;

		copyArray(copy, arr, n);
		start = chrono::high_resolution_clock::now();
		Sort::topDownMergeSort(copy, n);
		finish = chrono::high_resolution_clock::now();
		estimatedTime5 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count() / 1000;

		copyArray(copy, arr, n);
		start = chrono::high_resolution_clock::now();
		Sort::bottomUpMergeSort(copy, n);
		finish = chrono::high_resolution_clock::now();
		estimatedTime6 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count() / 1000;

		copyArray(copy, arr, n);
		start = chrono::high_resolution_clock::now();
		Sort::shellSort(copy, n);
		finish = chrono::high_resolution_clock::now();
		estimatedTime7 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count() / 1000;

		copyArray(copy, arr, n);
		start = chrono::high_resolution_clock::now();
		Sort::heapSort(copy, n);
		finish = chrono::high_resolution_clock::now();
		estimatedTime8 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count() / 1000;

		copyArray(copy, arr, n);
		start = chrono::high_resolution_clock::now();
		sort(arr, arr + n);
		finish = chrono::high_resolution_clock::now();
		estimatedTime9 += chrono::duration_cast<chrono::nanoseconds>(finish - start).count() / 1000;
	}

	//ofstream myfile;
	//myfile.open("CppArray.txt");
	cout << estimatedTime0 / repNr << endl;
	cout << estimatedTime1 / repNr << endl;
	cout << estimatedTime2 / repNr << endl;
	cout << estimatedTime3 / repNr << endl;
	cout << estimatedTime4 / repNr << endl;
	cout << estimatedTime5 / repNr << endl;
	cout << estimatedTime6 / repNr << endl;
	cout << estimatedTime7 / repNr << endl;
	cout << estimatedTime8 / repNr << endl;
	cout << estimatedTime9 / repNr << endl;
	//myfile.close();
}

vector<int> read(int n) {
	vector<int> arr;
	int a;
	ifstream file;
	file.open("plik");
	for (int i = 0; i < n; i++) {
		file >> a;
		arr.push_back(a);
	}
	file.close();
	return arr;
}

int main()
{
	int n = 10000; //25000, 50000
	vector<int>* vec = new vector<int>();
	*vec = read(n);
	testTime(*vec);
	int* arr = new int[n];
	int a;
	ifstream file;
	file.open("plik");
	for (int i = 0; i < n; i++) {
		file >> a;
		arr[i] = a;
	}
	file.close();
	testTime(arr, n);
	delete vec;
	delete arr;
}