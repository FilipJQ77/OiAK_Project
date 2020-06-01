using System;
using System.Collections.Generic;
using System.Text;

namespace ProgramNamespace
{
    class SortingHelper
    {
        public static int HeapSortHeapifyDown(IList<int> arr, int parentIndex, int arrCount)
        {
            int largestIndex = parentIndex;
            int leftIndex = 2 * parentIndex + 1;
            int rightIndex = 2 * parentIndex + 2;
            if (leftIndex < arrCount && arr[leftIndex] > arr[largestIndex])
                largestIndex = leftIndex;
            if (rightIndex < arrCount && arr[rightIndex] > arr[largestIndex])
                largestIndex = rightIndex;
            if (largestIndex != parentIndex)
            {
                int swap = arr[parentIndex];
                arr[parentIndex] = arr[largestIndex];
                arr[largestIndex] = swap;
                return largestIndex;
            }
            else
                return -1;
        }

        public static int QuickSortPartition(IList<int> arr, int low, int high)
        {
            int x = arr[high];
            int pivot = low - 1;
            int swap;
            for (int i = low; i < high; ++i)
            {
                if (arr[i] <= x)
                {
                    ++pivot;
                    swap = arr[pivot];
                    arr[pivot] = arr[i];
                    arr[i] = swap;
                }
            }
            ++pivot;
            swap = arr[pivot];
            arr[pivot] = arr[high];
            arr[high] = swap;
            return pivot;
        }

        public static void QuickSortRecursive(IList<int> arr, int low, int high)
        {
            if (low < high)
            {
                int pivot = QuickSortPartition(arr, low, high);
                QuickSortRecursive(arr, low, pivot - 1);
                QuickSortRecursive(arr, pivot + 1, high);
            }
        }
    }
}
