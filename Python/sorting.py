import random
import sorting_helper
from collections import deque


def check_sorting_method(func, arr: list) -> bool:
    func(arr)
    list_size = len(arr) - 1
    for i in range(list_size):
        if arr[i] > arr[i + 1]:
            return False
    return True


# https://en.wikipedia.org/wiki/Bubble_sort#Optimizing_bubble_sort
def bubble_sort(arr: list):
    n = len(arr)
    while n > 1:
        new_n = 0
        for i in range(1, n):
            if arr[i - 1] > arr[i]:
                arr[i - 1], arr[i] = arr[i], arr[i - 1]
                new_n = i
        n = new_n


# https://en.wikipedia.org/wiki/Heapsort#Pseudocode
def heap_sort(arr: list):
    len_arr = len(arr)
    for i in range((len_arr - 2) // 2, -1, -1):
        j = i
        while j != -1:
            j = sorting_helper.heap_sort_heapify_down(arr, j, len_arr)
    for i in range(len_arr - 1, 0, -1):
        arr[0], arr[i] = arr[i], arr[0]
        j = 0
        while j != -1:
            j = sorting_helper.heap_sort_heapify_down(arr, j, i)


# https://en.wikipedia.org/wiki/Insertion_sort#Algorithm
def insertion_sort(arr: list):
    for i in range(1, len(arr)):
        x = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > x:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = x
        i += 1


# https://en.wikipedia.org/wiki/Merge_sort#Top-down_implementation
# https://www.geeksforgeeks.org/merge-sort/
def merge_sort_recursive(arr: list):
    len_arr = len(arr)
    if len_arr > 1:
        middle = len_arr // 2
        left_arr = arr[:middle]
        merge_sort_recursive(left_arr)
        right_arr = arr[middle:]
        merge_sort_recursive(right_arr)
        len_left = len(left_arr)
        len_right = len(right_arr)
        sorting_helper.merge_sort_merge(arr, left_arr, right_arr, 0, len_left, len_right)


# https://en.wikipedia.org/wiki/Merge_sort#Bottom-up_implementation
# https://www.geeksforgeeks.org/iterative-merge-sort/
def merge_sort_iterative(arr: list):
    len_arr = len(arr)
    width = 1
    while width < len_arr:
        left = 0
        while left < len_arr:
            mid = min(left + width - 1, len_arr - 1)
            right = min(left + 2 * width - 1, len_arr - 1)
            len_left = mid - left + 1
            len_right = right - mid
            left_arr = [0] * len_left
            right_arr = [0] * len_right
            for i in range(0, len_left):
                left_arr[i] = arr[left + i]
            for i in range(0, len_right):
                right_arr[i] = arr[mid + i + 1]
            sorting_helper.merge_sort_merge(arr, left_arr, right_arr, left, len_left, len_right)
            left += width * 2
        width *= 2


# Cormen - Introduction to Algorithms - 7.1
def quick_sort_recursive(arr: list):
    sorting_helper.quick_sort_recursive(arr, 0, len(arr) - 1)


# https://www.geeksforgeeks.org/iterative-quick-sort/
def quick_sort_iterative(arr: list):
    low = 0
    high = len(arr) - 1
    stack = deque([low, high])
    while stack:
        high = stack.pop()
        low = stack.pop()
        pivot = sorting_helper.quick_sort_partition(arr, low, high) - 1
        if pivot > low:
            stack.append(low)
            stack.append(pivot)
        pivot += 2
        if pivot < high:
            stack.append(pivot)
            stack.append(high)


# https://en.wikipedia.org/wiki/Selection_sort#Implementations
def selection_sort(arr: list):
    len_arr = len(arr)
    for i in range(len_arr):
        min_index = i
        for j in range(i + 1, len_arr):
            if arr[j] < arr[min_index]:
                min_index = j
        if i != min_index:
            arr[i], arr[min_index] = arr[min_index], arr[i]


# https://en.wikipedia.org/wiki/Shellsort#Pseudocode
def shell_sort(arr: list):
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
