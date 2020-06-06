from time import perf_counter_ns as timer
import sorting


def time_test(arr):
    repeats = 10
    bubble_time = 0
    heap_time = 0
    insertion_time = 0
    merge_recursive_time = 0
    merge_iterative_time = 0
    quick_recursive_time = 0
    quick_iterative_time = 0
    selection_time = 0
    shell_time = 0
    library_time = 0
    for i in range(repeats):
        arr_copy = list.copy(arr)
        start = timer()
        sorting.bubble_sort(arr_copy)
        end = timer()
        bubble_time += end - start

        arr_copy = list.copy(arr)
        start = timer()
        sorting.heap_sort(arr_copy)
        end = timer()
        heap_time += end - start

        arr_copy = list.copy(arr)
        start = timer()
        sorting.insertion_sort(arr_copy)
        end = timer()
        insertion_time += end - start

        arr_copy = list.copy(arr)
        start = timer()
        sorting.merge_sort_recursive(arr_copy)
        end = timer()
        merge_recursive_time += end - start

        arr_copy = list.copy(arr)
        start = timer()
        sorting.merge_sort_iterative(arr_copy)
        end = timer()
        merge_iterative_time += end - start

        arr_copy = list.copy(arr)
        start = timer()
        sorting.quick_sort_recursive(arr_copy)
        end = timer()
        quick_recursive_time += end - start

        arr_copy = list.copy(arr)
        start = timer()
        sorting.quick_sort_iterative(arr_copy)
        end = timer()
        quick_iterative_time += end - start

        arr_copy = list.copy(arr)
        start = timer()
        sorting.selection_sort(arr_copy)
        end = timer()
        selection_time += end - start

        arr_copy = list.copy(arr)
        start = timer()
        sorting.shell_sort(arr_copy)
        end = timer()
        shell_time += end - start

        arr_copy = list.copy(arr)
        start = timer()
        list.sort(arr_copy)
        end = timer()
        library_time += end - start
    # * 1000 bo wynik domyślnie jest w nanosekundach
    bubble_time /= (repeats * 1000)
    heap_time /= (repeats * 1000)
    insertion_time /= (repeats * 1000)
    merge_recursive_time /= (repeats * 1000)
    merge_iterative_time /= (repeats * 1000)
    quick_recursive_time /= (repeats * 1000)
    quick_iterative_time /= (repeats * 1000)
    selection_time /= (repeats * 1000)
    shell_time /= (repeats * 1000)
    library_time /= (repeats * 1000)
    with open("Python_results.txt", "w") as file_results:
        file_results.write(str(bubble_time) + '\n')
        file_results.write(str(insertion_time) + '\n')
        file_results.write(str(selection_time) + '\n')
        file_results.write(str(quick_recursive_time) + '\n')
        file_results.write(str(quick_iterative_time) + '\n')
        file_results.write(str(merge_recursive_time) + '\n')
        file_results.write(str(merge_iterative_time) + '\n')
        file_results.write(str(shell_time) + '\n')
        file_results.write(str(heap_time) + '\n')
        file_results.write(str(library_time) + '\n')


if __name__ == "__main__":
    arr = []
    with open("plik") as file:
        for line in file:
            arr.append(int(line))
    time_test(arr)
    # arr_copy = list.copy(arr)
    # print("Enter")
    # input()
    # arr_copy.sort()
    # sorting.merge_sort_recursive(arr_copy)
    # print("End")
    # input()
