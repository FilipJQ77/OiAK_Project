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
        /// 
        /// </summary>
        public static void HeapSort(IList<int> arr)
        {
            int arrCount = arr.Count;
            for (int i = (arrCount - 2) / 2; i >= 0; --i)
            {
                int j = i;
                while (j != -1)
                    j = SortingHelper.HeapSortHeapifyDown(arr, j, arrCount);
            }
            for (int i = arrCount - 1; i > 0; --i)
            {
                int swap = arr[0];
                arr[0] = arr[i];
                arr[i] = swap;
                int j = 0;
                while (j != -1)
                    j = SortingHelper.HeapSortHeapifyDown(arr, j, i);
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
        /// https://en.wikipedia.org/wiki/Merge_sort#Top-down_implementation
        /// https://www.geeksforgeeks.org/merge-sort/
        /// </summary>
        public static void MergeSortRecursive(IList<int> arr)
        {
            int arrCount = arr.Count;
            if (arrCount > 1)
            {
                int middle = arrCount / 2;

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
            int high = arr.Count;
            Stack<int> stack = new Stack<int>();
            while (stack.Count > 0)
            {
                high = stack.Pop();
                low = stack.Pop();
                int pivot = SortingHelper.QuickSortPartition(arr, low, high)-1;
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
