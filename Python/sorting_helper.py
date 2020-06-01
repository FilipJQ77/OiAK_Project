# https://en.wikipedia.org/wiki/Binary_heap#Extract
def heap_sort_heapify_down(arr: list, parent_index: int, len_arr: int) -> int:
    largest_index = parent_index
    left_index = 2 * parent_index + 1
    right_index = 2 * parent_index + 2
    if left_index < len_arr and arr[left_index] > arr[largest_index]:
        largest_index = left_index
    if right_index < len_arr and arr[right_index] > arr[largest_index]:
        largest_index = right_index
    if largest_index != parent_index:
        arr[parent_index], arr[largest_index] = arr[largest_index], arr[parent_index]
        return largest_index
    else:
        return -1


def merge_sort_merge(arr, left_arr, right_arr, arr_i, left_i, right_i, len_left, len_right):
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


def quick_sort_partition(arr: list, low: int, high: int) -> int:
    x = arr[high]
    pivot = low - 1
    for i in range(low, high):
        if arr[i] <= x:
            pivot += 1
            arr[pivot], arr[i] = arr[i], arr[pivot]
    pivot += 1
    arr[pivot], arr[high] = arr[high], arr[pivot]
    return pivot


def quick_sort_recursive(arr: list, low: int, high: int):
    if low < high:
        pivot = quick_sort_partition(arr, low, high)
        quick_sort_recursive(arr, low, pivot - 1)
        quick_sort_recursive(arr, pivot + 1, high)
