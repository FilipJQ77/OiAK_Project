import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Sort {

    static void bubbleSort(List<Integer> arr)
    {
        int n = arr.size();
        int newn;
        do{
            newn = 0;
            for (int i = 1; i <= n - 1; i++){
                if (arr.get(i-1) > arr.get(i)){
                    int temp = arr.get(i);
                    arr.set(i,arr.get(i-1));
                    arr.set(i-1,temp);
                    newn = i;
                }
            }
            n = newn;
        } while (n > 1);
    }

    static void bubbleSort(int arr[])
    {
        int n = arr.length;
        int newn;
        do{
            newn = 0;
            for (int i = 1; i <= n - 1; i++){
                if (arr[i-1] > arr[i]){
                    int temp = arr[i-1];
                    arr[i-1] = arr[i];
                    arr[i] = temp;
                    newn = i;
                }
            }
            n = newn;
        } while (n > 1);
    }

    static void insertionSort(List<Integer> arr)
    {
        int i = 1, j;
        int n = arr.size();
        int x;
        while (i < n){
            x = arr.get(i);
            j = i - 1;
            while (j >= 0 && arr.get(j) > x){
                arr.set(j + 1, arr.get(j));
                j-=1;
            }
            arr.set(j + 1, x);
            i+=1;
        }
    }

    static void insertionSort(int arr[])
    {
        int i = 1, j;
        int n = arr.length;
        int x;
        while (i < n){
            x = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > x){
                arr[j+1] = arr[j];
                j-=1;
            }
            arr[j+1] = x;
            i+=1;
        }
    }

    static void selectionSort(List<Integer> arr)
    {
        int n = arr.size();
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr.get(j) < arr.get(min_idx))
                    min_idx = j;

            if (min_idx != i) {
                int temp = arr.get(min_idx);
                arr.set(min_idx, arr.get(i));
                arr.set(i, temp);
            }
        }
    }

    static void selectionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            if (min_idx != i) {
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
            }
        }
    }

    static void quickSortRec(List<Integer> arr)
    {
        SortHelper.qsSort(arr, 0, arr.size() - 1);
    }

    static void quickSortRec(int arr[])
    {
        SortHelper.qsSort(arr, 0, arr.length - 1);
    }

    static void quickSortIter(List<Integer> arr)
    {
        int l = 0;
        int h = arr.size() - 1;
        Stack stack = new Stack();

        stack.push(l);
        stack.push(h);

        while (!stack.empty()) {
            h = (int) stack.pop();
            l = (int) stack.pop();

            int p = SortHelper.qsPartition(arr, l, h);

            if (p - 1 > l) {
                stack.push(l);
                stack.push(p-1);
            }

            if (p + 1 < h) {
                stack.push(p+1);
                stack.push(h);
            }
        }
    }

    static void quickSortIter(int arr[])
    {
        int l = 0;
        int h = arr.length - 1;
        Stack stack = new Stack();

        stack.push(l);
        stack.push(h);

        while (!stack.empty()) {
            h = (int) stack.pop();
            l = (int) stack.pop();
            int p = SortHelper.qsPartition(arr, l, h);

            if (p - 1 > l) {
                stack.push(l);
                stack.push(p-1);
            }
            if (p + 1 < h) {
                stack.push(p+1);
                stack.push(h);
            }
        }
    }

    static void topDownMergeSort(int arr[])
    {
        int working_arr[] = arr.clone();
        SortHelper.topDownSplitMerge(working_arr, 0, arr.length, arr);
    }

    static void topDownMergeSort(ArrayList<Integer> arr)
    {
        ArrayList<Integer> working_arr = new ArrayList<>(arr);
        SortHelper.topDownSplitMerge(working_arr, 0, arr.size(), arr);
    }

    static void bottomUpMergeSort(int arr[])
    {
        int n = arr.length;
        int curr_size;
        int left_start;
        for (curr_size = 1; curr_size < n; curr_size *= 2){
            for (left_start = 0; left_start < n; left_start += 2*curr_size){
                SortHelper.bottomUpMerge (arr, left_start, Math.min(left_start+curr_size - 1, n - 1), Math.min(left_start+2*curr_size - 1,n - 1));
            }
        }
    }

    static void bottomUpMergeSort(List<Integer> arr)
    {
        int n = arr.size();
        int curr_size;
        int left_start;
        for (curr_size = 1; curr_size < n; curr_size *= 2){
            for (left_start = 0; left_start < n; left_start += 2*curr_size){
                SortHelper.bottomUpMerge (arr, left_start, Math.min(left_start+curr_size - 1, n - 1), Math.min(left_start+2*curr_size - 1,n - 1));
            }
        }
    }

    static void shellSort(int arr[]) {
        int n = arr.length;
        int gap = n / 2;
        while (gap > 0)
        {
            for (int i = gap; i < n; i++)
            {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[ j - gap] >temp)
                {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            gap /= 2;
        }
    }

    static void shellSort(List<Integer> arr) {
        int n = arr.size();
        int gap = n / 2;
        while (gap > 0)
        {
            for (int i = gap; i < n; i++)
            {
                int temp = arr.get(i);
                int j = i;
                while (j >= gap && arr.get(j - gap) >temp)
                {
                    arr.set(j, arr.get(j - gap));
                    j -= gap;
                }
                arr.set(j, temp);
            }
            gap /= 2;
        }
    }

    static void heapSort(int arr[])
    {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            SortHelper.heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            SortHelper.heapify(arr, i, 0);
        }
    }

    static void heapSort(List<Integer> arr)
    {
        int n = arr.size();
        for (int i = n / 2 - 1; i >= 0; i--)
            SortHelper.heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--){
            int temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);
            SortHelper.heapify(arr, i, 0);
        }
    }
}