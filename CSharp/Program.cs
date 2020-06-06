using System;
using System.Collections.Generic;
using System.Linq;
using System.Diagnostics;
using System.Threading;
using System.Text;
using System.Threading.Tasks;

namespace ProgramNamespace
{
    class Program
    {

        static bool CheckSortingMethod(IList<int> arr)
        {
            int lengthMinusOne = arr.Count - 1;
            for (int i = 0; i < lengthMinusOne; ++i)
            {
                if (arr[i] > arr[i + 1])
                    return false;
            }
            return true;
        }

        static void ArrayTimeTest(int[] arr)
        {
            int repeats = 10;
            Stopwatch stopwatch = new Stopwatch();
            long nanosecondsPerTick = (1000L * 1000L * 1000L) / Stopwatch.Frequency;
            long bubbleTime = 0, heapTime = 0, insertionTime = 0, mergeRecursiveTime = 0, mergeIterativeTime = 0, quickRecursiveTime = 0, quickIterativeTime = 0, selectionTime = 0, shellTime = 0, libraryTime = 0;
            int[] arrCopy = new int[arr.Length];
            for (int i = 0; i < repeats; ++i)
            {
                Array.Copy(arr, arrCopy, arr.Length);
                stopwatch.Start();
                Sorting.BubbleSort(arrCopy);
                stopwatch.Stop();
                bubbleTime += stopwatch.ElapsedTicks * nanosecondsPerTick;

                Array.Copy(arr, arrCopy, arr.Length);
                stopwatch.Reset();
                stopwatch.Start();
                Sorting.HeapSort(arrCopy);
                stopwatch.Stop();
                heapTime += stopwatch.ElapsedTicks * nanosecondsPerTick;

                Array.Copy(arr, arrCopy, arr.Length);
                stopwatch.Reset();
                stopwatch.Start();
                Sorting.InsertionSort(arrCopy);
                stopwatch.Stop();
                insertionTime += stopwatch.ElapsedTicks * nanosecondsPerTick;

                Array.Copy(arr, arrCopy, arr.Length);
                stopwatch.Reset();
                stopwatch.Start();
                Sorting.MergeSortRecursive(arrCopy);
                stopwatch.Stop();
                mergeRecursiveTime += stopwatch.ElapsedTicks * nanosecondsPerTick;

                Array.Copy(arr, arrCopy, arr.Length);
                stopwatch.Reset();
                stopwatch.Start();
                Sorting.MergeSortIterative(arrCopy);
                stopwatch.Stop();
                mergeIterativeTime += stopwatch.ElapsedTicks * nanosecondsPerTick;

                Array.Copy(arr, arrCopy, arr.Length);
                stopwatch.Reset();
                stopwatch.Start();
                Sorting.QuickSortRecursive(arrCopy);
                stopwatch.Stop();
                quickRecursiveTime += stopwatch.ElapsedTicks * nanosecondsPerTick;

                Array.Copy(arr, arrCopy, arr.Length);
                stopwatch.Reset();
                stopwatch.Start();
                Sorting.QuickSortIterative(arrCopy);
                stopwatch.Stop();
                quickIterativeTime += stopwatch.ElapsedTicks * nanosecondsPerTick;

                Array.Copy(arr, arrCopy, arr.Length);
                stopwatch.Reset();
                stopwatch.Start();
                Sorting.SelectionSort(arrCopy);
                stopwatch.Stop();
                selectionTime += stopwatch.ElapsedTicks * nanosecondsPerTick;

                Array.Copy(arr, arrCopy, arr.Length);
                stopwatch.Reset();
                stopwatch.Start();
                Sorting.ShellSort(arrCopy);
                stopwatch.Stop();
                shellTime += stopwatch.ElapsedTicks * nanosecondsPerTick;

                Array.Copy(arr, arrCopy, arr.Length);
                stopwatch.Reset();
                stopwatch.Start();
                Array.Sort(arrCopy);
                stopwatch.Stop();
                libraryTime += stopwatch.ElapsedTicks * nanosecondsPerTick;
            }
            bubbleTime /= (repeats * 1000);
            heapTime /= (repeats * 1000);
            insertionTime /= (repeats * 1000);
            mergeRecursiveTime /= (repeats * 1000);
            mergeIterativeTime /= (repeats * 1000);
            quickRecursiveTime /= (repeats * 1000);
            quickIterativeTime /= (repeats * 1000);
            selectionTime /= (repeats * 1000);
            shellTime /= (repeats * 1000);
            libraryTime /= (repeats * 1000);
            Console.WriteLine(bubbleTime);
            Console.WriteLine(insertionTime);
            Console.WriteLine(selectionTime);
            Console.WriteLine(quickRecursiveTime);
            Console.WriteLine(quickIterativeTime);
            Console.WriteLine(mergeRecursiveTime);
            Console.WriteLine(mergeIterativeTime);
            Console.WriteLine(shellTime);
            Console.WriteLine(heapTime);
            Console.WriteLine(libraryTime);
        }

        static void ListTimeTest(List<int> list)
        {
            int repeats = 10;
            Stopwatch stopwatch = new Stopwatch();
            long nanosecondsPerTick = (1000L * 1000L * 1000L) / Stopwatch.Frequency;
            long bubbleTime = 0, heapTime = 0, insertionTime = 0, mergeRecursiveTime = 0, mergeIterativeTime = 0, quickRecursiveTime = 0, quickIterativeTime = 0, selectionTime = 0, shellTime = 0, libraryTime = 0;
            for (int i = 0; i < repeats; ++i)
            {
                var listCopy = new List<int>(list);
                stopwatch.Start();
                Sorting.BubbleSort(listCopy);
                stopwatch.Stop();
                bubbleTime += stopwatch.ElapsedTicks * nanosecondsPerTick;

                listCopy = new List<int>(list);
                stopwatch.Reset();
                stopwatch.Start();
                Sorting.HeapSort(listCopy);
                stopwatch.Stop();
                heapTime += stopwatch.ElapsedTicks * nanosecondsPerTick;

                listCopy = new List<int>(list);
                stopwatch.Reset();
                stopwatch.Start();
                Sorting.InsertionSort(listCopy);
                stopwatch.Stop();
                insertionTime += stopwatch.ElapsedTicks * nanosecondsPerTick;

                listCopy = new List<int>(list);
                stopwatch.Reset();
                stopwatch.Start();
                Sorting.MergeSortRecursive(listCopy);
                stopwatch.Stop();
                mergeRecursiveTime += stopwatch.ElapsedTicks * nanosecondsPerTick;

                listCopy = new List<int>(list);
                stopwatch.Reset();
                stopwatch.Start();
                Sorting.MergeSortIterative(listCopy);
                stopwatch.Stop();
                mergeIterativeTime += stopwatch.ElapsedTicks * nanosecondsPerTick;

                listCopy = new List<int>(list);
                stopwatch.Reset();
                stopwatch.Start();
                Sorting.QuickSortRecursive(listCopy);
                stopwatch.Stop();
                quickRecursiveTime += stopwatch.ElapsedTicks * nanosecondsPerTick;

                listCopy = new List<int>(list);
                stopwatch.Reset();
                stopwatch.Start();
                Sorting.QuickSortIterative(listCopy);
                stopwatch.Stop();
                quickIterativeTime += stopwatch.ElapsedTicks * nanosecondsPerTick;

                listCopy = new List<int>(list);
                stopwatch.Reset();
                stopwatch.Start();
                Sorting.SelectionSort(listCopy);
                stopwatch.Stop();
                selectionTime += stopwatch.ElapsedTicks * nanosecondsPerTick;

                listCopy = new List<int>(list);
                stopwatch.Reset();
                stopwatch.Start();
                Sorting.ShellSort(listCopy);
                stopwatch.Stop();
                shellTime += stopwatch.ElapsedTicks * nanosecondsPerTick;

                listCopy = new List<int>(list);
                stopwatch.Reset();
                stopwatch.Start();
                listCopy.Sort();
                stopwatch.Stop();
                libraryTime += stopwatch.ElapsedTicks * nanosecondsPerTick;
            }
            bubbleTime /= (repeats * 1000);
            heapTime /= (repeats * 1000);
            insertionTime /= (repeats * 1000);
            mergeRecursiveTime /= (repeats * 1000);
            mergeIterativeTime /= (repeats * 1000);
            quickRecursiveTime /= (repeats * 1000);
            quickIterativeTime /= (repeats * 1000);
            selectionTime /= (repeats * 1000);
            shellTime /= (repeats * 1000);
            libraryTime /= (repeats * 1000);
            Console.WriteLine(bubbleTime);
            Console.WriteLine(insertionTime);
            Console.WriteLine(selectionTime);
            Console.WriteLine(quickRecursiveTime);
            Console.WriteLine(quickIterativeTime);
            Console.WriteLine(mergeRecursiveTime);
            Console.WriteLine(mergeIterativeTime);
            Console.WriteLine(shellTime);
            Console.WriteLine(heapTime);
            Console.WriteLine(libraryTime);
        }

        static int[] loadArrayFromFile(string filename)
        {
            string[] lines = System.IO.File.ReadAllLines(filename);
            int[] array = new int[lines.Length];
            int i = 0;
            foreach (string line in lines)
            {
                array[i] = Int32.Parse(line);
                ++i;
            }
            return array;
        }

        static List<int> loadListFromFile(string filename)
        {
            string[] lines = System.IO.File.ReadAllLines(filename);
            List<int> list = new List<int>();
            foreach (string line in lines)
            {
                list.Add(Int32.Parse(line));
            }
            return list;
        }

        static void Main(string[] args)
        {
            //int[] array = loadArrayFromFile("plik");
            //ArrayTimeTest(array);
        }
    }
}
