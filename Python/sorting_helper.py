def qs_partition(arr: list, low: int, high: int) -> int:
    x = arr[high]
    i = low - 1
    for j in range(low, high):
        if arr[j] <= x:
            i += 1
            arr[i], arr[j] = arr[j], arr[i]
    i += 1
    arr[i], arr[high] = arr[high], arr[i]
    return i


def qs_sort_recursive(arr: list, low: int, high: int) -> list:
    if low < high:
        pivot = qs_partition(arr, low, high)
        qs_sort_recursive(arr, low, pivot - 1)
        qs_sort_recursive(arr, pivot + 1, high)
    return arr
