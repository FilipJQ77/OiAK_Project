using System;
using System.Collections.Generic;
using System.Globalization;

namespace ProgramNamespace
{
    class Sorting
    {

        /// <summary>
        /// https://en.wikipedia.org/wiki/Bubble_sort#Optimizing_bubble_sort
        /// </summary>
        public static void BubbleSort(IList<int> arr)
        {
            int n = arr.Count;
            while (n > 1)
            {
                int newN = 0;
                for (int i = 1; i < n; ++i)
                {
                    if (arr[i - 1] > arr[i])
                    {
                        int temp = arr[i - 1];
                        arr[i - 1] = arr[i];
                        arr[i] = temp;
                        newN = i;
                    }

                }
                n = newN;
            }
        }

        /// <summary>
        /// https://en.wikipedia.org/wiki/Heapsort#Pseudocode
        /// </summary>
        public static void HeapSort(IList<int> arr)
        {
            int arrCount = arr.Count;
            for (int i = (arrCount - 2) / 2; i >= 0; --i)
            {
                SortingHelper.HeapSortHeapifyDown(arr, i, arrCount);
            }
            for (int i = arrCount - 1; i > 0; --i)
            {
                int swap = arr[0];
                arr[0] = arr[i];
                arr[i] = swap;
                SortingHelper.HeapSortHeapifyDown(arr, 0, i);
            }
        }

        /// <summary>
        /// https://en.wikipedia.org/wiki/Insertion_sort#Algorithm
        /// </summary>
        public static void InsertionSort(IList<int> arr)
        {
            int i = 1;
            int arrCount = arr.Count;
            while (i < arrCount)
            {
                int x = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > x)
                {
                    arr[j + 1] = arr[j];
                    --j;
                }
                arr[j + 1] = x;
                ++i;
            }
        }

        /// <summary>
        /// https://en.wikipedia.org/wiki/Merge_sort#Bottom-up_implementation
        /// https://www.geeksforgeeks.org/iterative-merge-sort/
        /// </summary>
        public static void MergeSortIterative(IList<int> arr)
        {
            int arrCount = arr.Count;
            for (int width = 1; width < arrCount; width *= 2)
            {
                for (int left = 0; left < arrCount; left += width * 2)
                {
                    int middle = Math.Min(left + width - 1, arrCount - 1);
                    int right = Math.Min(left + 2 * width - 1, arrCount - 1);
                    int leftCount = middle - left + 1;
                    int rightCount = right - middle;
                    int[] leftArr = new int[leftCount];
                    int[] rightArr = new int[rightCount];
                    for (int i = 0; i < leftCount; ++i)
                    {
                        leftArr[i] = arr[left + 1];
                    }
                    for (int i = 0; i < rightCount; ++i)
                    {
                        rightArr[i] = arr[middle + i + 1];
                    }
                    SortingHelper.MergeSortMerge(arr, leftArr, rightArr, left, leftCount, rightCount);
                }
            }
        }

        /// <summary>
        /// https://en.wikipedia.org/wiki/Merge_sort#Top-down_implementation
        /// https://www.geeksforgeeks.org/merge-sort/
        /// </summary>
        public static void MergeSortRecursive(IList<int> arr)
        {
            int arrCount = arr.Count;
            if (arrCount > 1)
            {
                int middle = arrCount / 2;
                int[] leftArray = new int[middle];
                int i = 0;
                for (; i < middle; ++i)
                {
                    leftArray[i] = arr[i];
                }
                MergeSortRecursive(leftArray);
                int[] rightArray = new int[arrCount - middle];
                for (int j = 0; j < arrCount - middle; ++j)
                {
                    rightArray[j] = arr[i];
                }
                MergeSortRecursive(rightArray);
                SortingHelper.MergeSortMerge(arr, leftArray, rightArray, 0, leftArray.Length, rightArray.Length);
            }
        }

        /// <summary>
        /// Cormen 7.1
        /// </summary>
        public static void QuickSortRecursive(IList<int> arr)
        {
            SortingHelper.QuickSortRecursive(arr, 0, arr.Count - 1);
        }

        /// <summary>
        /// https://www.geeksforgeeks.org/iterative-quick-sort/
        /// </summary>
        public static void QuickSortIterative(IList<int> arr)
        {
            int low = 0;
            int high = arr.Count - 1;
            Stack<int> stack = new Stack<int>();
            stack.Push(low);
            stack.Push(high);
            while (stack.Count > 0)
            {
                high = stack.Pop();
                low = stack.Pop();
                int pivot = SortingHelper.QuickSortPartition(arr, low, high) - 1;
                if (pivot > low)
                {
                    stack.Push(low);
                    stack.Push(pivot);
                }
                pivot += 2;
                if (pivot < high)
                {
                    stack.Push(pivot);
                    stack.Push(high);
                }
            }

        }

        /// <summary>
        /// https://en.wikipedia.org/wiki/Selection_sort#Implementations
        /// </summary>
        public static void SelectionSort(IList<int> arr)
        {
            int arrCount = arr.Count;
            for (int i = 0; i < arrCount; ++i)
            {
                int minIndex = i;
                for (int j = i + 1; j < arrCount; ++j)
                {
                    if (arr[j] < arr[minIndex])
                        minIndex = j;
                }
                if (i != minIndex)
                {
                    int temp = arr[i];
                    arr[i] = arr[minIndex];
                    arr[minIndex] = arr[i];
                }
            }
        }

        /// <summary>
        /// https://en.wikipedia.org/wiki/Shellsort#Pseudocode
        /// </summary>
        public static void ShellSort(IList<int> arr)
        {
            int arrCount = arr.Count;
            for (int gap = arrCount / 2; gap > 0; gap /= 2)
            {
                for (int i = gap; i < arrCount; ++i)
                {
                    int temp = arr[i];
                    int j = i;
                    for (; j >= gap && arr[j - gap] > temp; j -= gap)
                    {
                        arr[j] = arr[j - gap];
                    }
                    arr[j] = temp;
                }
            }

        }

    }
}
