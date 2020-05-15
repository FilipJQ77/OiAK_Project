import random
import sorting_helper


def generate_data(amount: int, mini: int, maxi: int) -> list:
    data = []
    for i in range(amount):
        data.append(random.randint(mini, maxi))
    return data


def check_sorting_method(func, arr: list) -> bool:
    arr = func(arr)
    list_size = len(arr) - 1
    for i in range(list_size):
        if arr[i] > arr[i + 1]:
            return False
    return True


# https://en.wikipedia.org/wiki/Bubble_sort#Optimizing_bubble_sort
def bubble_sort(arr: list) -> list:
    n = len(arr)
    while n > 1:
        new_n = 0
        for i in range(1, n):
            if arr[i - 1] > arr[i]:
                arr[i - 1], arr[i] = arr[i], arr[i - 1]
                new_n = i
        n = new_n
    return arr


# https://en.wikipedia.org/wiki/Insertion_sort#Algorithm
def insertion_sort(arr: list) -> list:
    i = 1
    len_arr = len(arr)
    while i < len_arr:
        x = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > x:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = x
        i += 1
    return arr


# https://en.wikipedia.org/wiki/Merge_sort#Top-down_implementation
# https://www.geeksforgeeks.org/merge-sort/
def merge_sort_recursive(arr: list) -> list:
    len_arr = len(arr)
    if len_arr > 1:
        middle = len_arr // 2
        left_arr = arr[:middle]
        merge_sort_recursive(left_arr)
        right_arr = arr[middle:]
        merge_sort_recursive(right_arr)
        len_left = len(left_arr)
        len_right = len(right_arr)
        left_i = right_i = arr_i = 0
        while left_i < len_left and right_i < len_right:
            if left_arr[left_i] < right_arr[right_i]:
                arr[arr_i] = left_arr[left_i]
                left_i += 1
            else:
                arr[arr_i] = right_arr[right_i]
                right_i += 1
            arr_i += 1
        while left_i < len_left:
            arr[arr_i] = left_arr[left_i]
            left_i += 1
            arr_i += 1
        while right_i < len_right:
            arr[arr_i] = right_arr[right_i]
            right_i += 1
            arr_i += 1
    return arr


# https://en.wikipedia.org/wiki/Merge_sort#Bottom-up_implementation
def merge_sort_iterative(arr: list) -> list:
    len_arr = len(arr)
    width = 1
    while width < len_arr:
        i = 0
        while i < len_arr:
            left_arr = arr[i:i + width - 1]
            right_arr = arr[i + width:i + 2 * width - 1]
            # todo
            i += width * 2
        width *= 2
    return arr


# Cormen 7.1
def quick_sort_recursive(arr: list) -> list:
    return sorting_helper.qs_sort_recursive(arr, 0, len(arr) - 1)


# https://www.geeksforgeeks.org/iterative-quick-sort/
def quick_sort_iterative(arr: list) -> list:
    low = 0
    high = len(arr) - 1
    size = high + 1
    stack = [0] * size
    top = 0
    stack[top] = low
    top += 1
    stack[top] = high
    while top >= 0:
        high = stack[top]
        top -= 1
        low = stack[top]
        top -= 1
        pivot = sorting_helper.qs_partition(arr, low, high) - 1
        if pivot > low:
            top += 1
            stack[top] = low
            top += 1
            stack[top] = pivot
        pivot += 2
        if pivot < high:
            top += 1
            stack[top] = pivot
            top += 1
            stack[top] = high
    return arr


# https://en.wikipedia.org/wiki/Selection_sort#Implementations
def selection_sort(arr: list) -> list:
    len_arr = len(arr)
    for i in range(len_arr):
        min_index = i
        for j in range(i + 1, len_arr):
            if arr[j] < arr[min_index]:
                min_index = j
        if i != min_index:
            arr[i], arr[min_index] = arr[min_index], arr[i]
    return arr


# https://en.wikipedia.org/wiki/Shellsort#Pseudocode
def shell_sort(arr: list) -> list:
    len_arr = len(arr)
    gap = len_arr // 2
    while gap > 0:
        for i in range(gap, len_arr):
            temp = arr[i]
            j = i
            while j >= gap and arr[j - gap] > temp:
                arr[j] = arr[j - gap]
                j -= gap
            arr[j] = temp
        gap //= 2
    return arr


for aaa in range(1000):
    lista = generate_data(1000, 0, 10000)
    if not check_sorting_method(shell_sort, lista):
        print("Ała kurwa rzeczywiście")

# time_bubble = []
# time_insertion = []
# time_quick = []
# time_selection = []
#
# for i in range(1000):
#     lista = generate_data(10, 0, 100)
#     lista = quick_sort_iterative(lista)
#     if not check_data(lista):
#         print("Yikeserino")
#
# for a in range(10, 900, 10):
#     lista = generate_data(a, 0, 2000000000)
#     start = timer()
#     lista1 = bubble_sort(lista)
#     end = timer()
#     time = end - start
#     print(f"Bubblesort on {a} sized list, time: {time}")
#     time_bubble.append(time)
#     start = timer()
#     lista1 = insertion_sort(lista)
#     end = timer()
#     time = end - start
#     print(f"Insertionsort on {a} sized list, time: {time}")
#     time_insertion.append(time)
#     start = timer()
#     lista1 = quick_sort_recursive(lista)
#     end = timer()
#     time = end - start
#     print(f"Quicksort on {a} sized list, time: {time}")
#     time_quick.append(time)
#     start = timer()
#     lista1 = selection_sort(lista)
#     end = timer()
#     time = end - start
#     print(f"Selectionsort on {a} sized list, time: {time}")
#     time_selection.append(time)
# print(f"Bubble average time: {math.fsum(time_bubble) / len(time_bubble)}")
# print(f"Insertion average time: {math.fsum(time_insertion) / len(time_insertion)}")
# print(f"Quick average time: {math.fsum(time_quick) / len(time_quick)}")
# print(f"Selection average time: {math.fsum(time_selection) / len(time_selection)}")
