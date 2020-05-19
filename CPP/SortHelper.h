#pragma once
#include <vector>
using std::vector;
class SortHelper
{
	public:
	static vector<int> qsSort(vector<int>& arr, int low, int high);
	static int qsPartition(vector<int>& arr, int low, int high);
	static void topDownSplitMerge(vector<int>& working_arr, int iBegin, int iEnd, vector<int>& arr);
	static void bottomUpMerge(vector<int>& arr, int l, int m, int r);
	static void heapify(vector<int>& arr, int n, int i);

	static int* qsSort(int* arr, int low, int high);
	static int qsPartition(int* arr, int low, int high);
	static void topDownSplitMerge(int* working_arr, int iBegin, int iEnd, int* arr);
	static void bottomUpMerge(int* arr, int l, int m, int r);
	static void heapify(int* arr, int n, int i);
};

