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

        static bool test(IList<int> arr)
        {
            int lengthMinusOne = arr.Count - 1;
            for (int i = 0; i < lengthMinusOne; ++i)
            {
                if (arr[i] > arr[i + 1])
                    return false;
            }
            return true;
        }

        static void Main(string[] args)
        {
            Stopwatch stopwatch = new Stopwatch();
            stopwatch.Start();
            Thread.Sleep(2000);
            stopwatch.Stop();
            Thread.Sleep(1000);
            long milliseconds = stopwatch.ElapsedMilliseconds;
            Console.WriteLine(milliseconds);
            stopwatch.Reset();
            stopwatch.Start();
            Thread.Sleep(4000);
            stopwatch.Stop();
            Thread.Sleep(500);
            milliseconds = stopwatch.ElapsedMilliseconds;
            Console.WriteLine(milliseconds);
            Random random = new Random(1);
            List<int> arr = new List<int>();
            while (true)
            {
                arr.Clear();
                for (int i = 0; i < 100; ++i)
                {
                    arr.Append(random.Next());
                }
                Sorting.QuickSortIterative(arr);
                if (!test(arr))
                {
                    Console.WriteLine("shell pls");
                }
            }
        }
    }
}
